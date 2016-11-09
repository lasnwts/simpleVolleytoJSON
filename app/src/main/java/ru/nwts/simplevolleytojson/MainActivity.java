package ru.nwts.simplevolleytojson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * https://www.simplifiedcoding.net/android-volley-tutorial-to-get-json-from-server/
     * Android Volley Tutorial to Get JSON from Server
     * @param savedInstanceState
     */

    private final String TAG = "MyLogs";
    public static final String JSON_URL = "http://simplifiedcoding.16mb.com/UserRegistration/json.php";

    private Button buttonGet;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"MainActivity Started");

        test();

    }

    public void test(){
      int i = 1;
    }

    @Override
    public void onClick(View view) {

    }
}
