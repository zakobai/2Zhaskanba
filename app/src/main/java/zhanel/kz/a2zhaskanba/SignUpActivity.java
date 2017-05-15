package zhanel.kz.a2zhaskanba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import android.content.Intent;

public class SignUpActivity extends AppCompatActivity {
    private EditText userNameView;
    private EditText passwordView;
    private EditText passwordAgainView;
    private Button actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userNameView = (EditText) findViewById(R.id.userNameView);
        passwordView = (EditText) findViewById(R.id.passWordView);
        passwordAgainView = (EditText) findViewById(R.id.passwordAgain);

        actionButton = (Button) findViewById(R.id.signUpButton);

//        actionButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                boolean validationError = false;
//                StringBuilder validationErrorMessage = new StringBuilder("Please  ");
////                if (isEmpty(userNameView)) {
////
////                }
////            }
//

            //});
//        findViewById(R.id.action_button).setOnClickListener((view) -> {
//            boolean validationError = false;
//            StringBuilder validationErrorMessage = new StringBuilder("Please  ");
//if (isEmpty(userNameView)) {
//    validationError = true;
//    validationErrorMessage

//         });


    }
}

