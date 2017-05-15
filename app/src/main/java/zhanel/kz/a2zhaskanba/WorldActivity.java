package zhanel.kz.a2zhaskanba;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WorldActivity extends AppCompatActivity {
    private RecyclerView mRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("onresume", "onResume: ");
        getItems();
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_world, container, false);
        mRecycler = (RecyclerView) rootView.findViewById(R.id.tasks_recycler_view);
        return rootView;
    }

    private void getItems() {

    }
}

