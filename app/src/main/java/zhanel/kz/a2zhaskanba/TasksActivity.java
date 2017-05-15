package zhanel.kz.a2zhaskanba;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TasksActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_PLAY = 5;
    private Button balaButton;
    private Button takeButton;
    private Button worldButton;
    private Button taskButton;
    private Button profileButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);


        balaButton = (Button) findViewById(R.id.balaButton);
        takeButton = (Button) findViewById(R.id.takeButton);
        worldButton = (Button) findViewById(R.id.worldButton);
        profileButton = (Button) findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onProfileButtonClick();


            }
        });

//        taskButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v){
//                onTaskButtonClick();
//
//
//            }
//        });

worldButton.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v)
    {
        onWorldButtonClick();
    }
                    });

//        worldButton.setOnClickListener(new View.OnClickListener() {
//         public void onClick(View v)
//            {
//                onWorldButtonClick();
//        }
//    });

        balaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                onBalaButtonClick();


            }
        });

        takeButton.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View v) {
                onTakeButton();
            }
        });
    }

//    private void onTaskButtonClick() {
//        Intent intent = new Intent(this, TasksActivity.class);
//        startActivityForResult(intent,REQUEST_CODE_PLAY);
//    }
    private void onWorldButtonClick() {
        Intent intent = new Intent(this, RecycleActivity.class);
        startActivityForResult(intent,REQUEST_CODE_PLAY);
    }
    private void onBalaButtonClick() {
        Intent intent = new Intent(this, ZhBalaActivity.class);
        startActivityForResult(intent,REQUEST_CODE_PLAY);
    }
    private void onProfileButtonClick() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivityForResult(intent,REQUEST_CODE_PLAY);
    }
    private void onTakeButton() {
        Snackbar.make(takeButton,"Принято" , Snackbar.LENGTH_SHORT).show();
    }

}
