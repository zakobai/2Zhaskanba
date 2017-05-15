package zhanel.kz.a2zhaskanba;



        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

public class RecycleActivity extends Activity {

    String[] names = { "danchoka", "zakobai", "janara2406", "flyflyperson", "zmarazmik", "tolkyzbolatkyzy",
            "a.v.zh" };

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        // находим список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

    }
}