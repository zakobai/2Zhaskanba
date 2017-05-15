package zhanel.kz.a2zhaskanba;

import android.app.Application;

import com.parse.AuthenticationCallback;
import com.parse.Parse;
import com.parse.ParseUser;

import java.util.Map;

/**
 * Created by macbook on 15.05.17.
 */

public class SampleApplication extends Application {
        @Override
        public void onCreate() {
            Parse.initialize(new Parse.Configuration.Builder(this)
                    .applicationId("9Ug7M3TseZ0r5MAu3ELzFOxWVMEGQvuN9Mv5AeIUD7A")
                    .server("http://ec2-54-162-214-251.compute-1.amazonaws.com/parse-dev")
                    .clientKey("ZdodK9EVRPCF89tfqb8o/Ro07KbpkZuv1CUlF2ZWkx8")
                    .build()

            );
            ParseUser.registerAuthenticationCallback("instagram", new AuthenticationCallback() {
                @Override
                public boolean onRestore(Map<String, String> authData) {
                    return true;
                }
            });
        }

}


