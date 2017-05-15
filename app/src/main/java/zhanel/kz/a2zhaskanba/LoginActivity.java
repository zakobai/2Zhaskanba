package zhanel.kz.a2zhaskanba;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.Callable;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_PLAY = 5;
    private Button loginButton;
    private Button signInButton;
    private Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signInButton = (Button) findViewById(R.id.InButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v){
        onLoginButtonClick();
}
        });


        signUpButton = (Button) findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                onSignUpButtonClick();
            }


        });
    }


//    private void onLoginButtonClick() {
//        final Uri.Builder uriBuilder = new Uri.Builder();
//        uriBuilder.scheme("https")
//                .authority("api.instagram.com")
//                .appendPath("oauth")
//                .appendPath("authorize")
//                .appendQueryParameter("client_id", "3d894b6f3a234165ab07ab584ccd17e2")
//                .appendQueryParameter("redirect_uri", "http://localhost/")
//                .appendQueryParameter("response_type", "token");
//        final Intent browser = new Intent(Intent.ACTION_VIEW, uriBuilder.build());
//        startActivity(browser);
//        System.out.println("зашла в функциию");
//    }
//    private void checkForInstagramData() {
//        final Uri data = this.getIntent().getData();
//        if(data != null && data.getScheme().equals("sociallogin") && data.getFragment() != null) {
//            final String accessToken = data.getFragment().replaceFirst("access_token=", "");
//            if (accessToken != null) {
//                handleSignInResult(new Callable<Void>() {
//                    @Override
//                    public Void call() throws Exception {
//                        // Do nothing, just throw the access token away.
//                        return null;
//                    }
//                });
//            } else {
//                handleSignInResult(null);
//            }
//        }
//    }
//    private void handleSignInResult(Callable<Void> logout) {
//        if(logout == null) {
//            /* Login error */
//            Toast.makeText(getApplicationContext(), "owibka", Toast.LENGTH_SHORT).show();
//        } else {
//            /* Login success */
//            Application.getInstance().setLogoutCallable(logout);
//            startActivity(new Intent(this, TasksActivity.class));
//        }
//    }
    private void onLoginButtonClick() {
   Intent intent = new Intent(this, SignUpActivity.class);
    startActivityForResult(intent,REQUEST_CODE_PLAY);



    }
 private void onSignUpButtonClick() {
     Intent intent = new Intent(this, SignInActivity.class);
     startActivityForResult(intent,REQUEST_CODE_PLAY);
 }


}
