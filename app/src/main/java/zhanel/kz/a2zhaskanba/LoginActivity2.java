package zhanel.kz.a2zhaskanba;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import bolts.Continuation;
import bolts.Task;
import zhanel.kz.a2zhaskanba.library.instagram.Instagram;
import zhanel.kz.a2zhaskanba.library.instagram.InstagramUser;

/**
 * Created by madi on 1/25/17.
 */

public class LoginActivity2 extends AppCompatActivity {
    private static final String TAG = "LoginAct2";

    private ParseUser mCurrentUser;

    private String mUsername;
    private Bitmap mProfileBitmap;

    private  zhanel.kz.a2zhaskanba.library.instagram.Instagram mInstagram;
    private  zhanel.kz.a2zhaskanba.library.instagram.InstagramSession mInstagramSession;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private void getUserDetailsFromParse() {
        mCurrentUser = ParseUser.getCurrentUser();
        startActivity(new Intent(LoginActivity2.this, TasksActivity.class));
        finish();
    }

    private class ProfilePhotoAsync extends AsyncTask<String, String, String> {
        public Bitmap bitmap;
        String url;

        public ProfilePhotoAsync(String url) {
            this.url = url;
        }

        @Override
        protected String doInBackground(String... params) {
            // Fetching data from URI and storing in bitmap
            bitmap = DownloadImageBitmap(url);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mProfileBitmap = bitmap;
            saveNewUser();
        }
    }

    private void saveNewUser() {
        mCurrentUser = ParseUser.getCurrentUser();
        if (mUsername != null) {
            mCurrentUser.put("nickname", mUsername);
            mCurrentUser.setUsername(mUsername);
        }
//        Saving profile photo as a ParseFile
        if (mProfileBitmap != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Bitmap bitmap = mProfileBitmap;
            bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
            byte[] data = stream.toByteArray();
            String thumbName = mCurrentUser.getUsername().replaceAll("\\s+", "");
            final ParseFile parseFile = new ParseFile(thumbName + "_thumb.jpg", data);
            parseFile.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    mCurrentUser.put("image", parseFile);
                    //Finally save all the user details
                    mCurrentUser.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                startActivity(new Intent(LoginActivity2.this, TasksActivity.class));
                                finish();
                            } else {

                            }
                        }
                    });
                }
            });
        }
    }

    public static Bitmap DownloadImageBitmap(String url) {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e("IMAGE", "Error getting bitmap", e);
        }
        return bm;
    }

    public void onInstagramSignInPressed(View view) {
        mInstagram = new Instagram(this,
                "3d894b6f3a234165ab07ab584ccd17e2",
                "7ed5c3fa27b54ec88a97bfd88e19edd9",
                "http://localhost/");

        mInstagram.authorize(new Instagram.InstagramAuthListener() {
            @Override
            public void onSuccess(final InstagramUser user) {
                Map<String, String> map = new HashMap<>();
                map.put("id", user.id);
                map.put("access_token", user.accessToken);

                Task<ParseUser> instagramTask = ParseUser.logInWithInBackground("instagram", map);

                instagramTask.onSuccess(new Continuation<ParseUser, Object>() {
                    @Override
                    public Object then(Task<ParseUser> task) throws Exception {

                        ParseUser currentUser = task.getResult();
                        if (currentUser == null) {
                            Toast.makeText(LoginActivity2.this, "user is null", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "");
                        } else if (currentUser.isNew()) {
                            Toast.makeText(LoginActivity2.this, "user is new", Toast.LENGTH_SHORT).show();

                            getUserDetailsFromInstagram(user);
                        } else {
                            Toast.makeText(LoginActivity2.this, "user is old", Toast.LENGTH_SHORT).show();

                            Log.d(TAG, "then: old user");
                            getUserDetailsFromParse();
                        }
                        return currentUser;
                    }
                });


            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "Instagram Login error: " + error);
                Toast.makeText(LoginActivity2.this, error, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "Instagram Login canceled");
            }
        });
    }

    private void getUserDetailsFromInstagram(InstagramUser user) {
        if (!user.username.isEmpty()) {
            mUsername = user.username;
        }
        if (!user.profilPicture.isEmpty()) {
            new ProfilePhotoAsync(user.profilPicture).execute();
        } else {
            saveNewUser();
        }

    }
}
