package zhanel.kz.a2zhaskanba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignInActivity extends AppCompatActivity {
    private Button actionButton;
    private static final int REQUEST_CODE_PLAY = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        actionButton = (Button) findViewById(R.id.action_button);

        actionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                onLoginButtonClick();
            }
        });

    }


   public void onLoginButtonClick() {
       Intent intent = new Intent(this, TasksActivity.class);
       startActivityForResult(intent,REQUEST_CODE_PLAY);
   }
}
