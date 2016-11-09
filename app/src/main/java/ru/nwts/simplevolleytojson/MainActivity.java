package ru.nwts.simplevolleytojson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    /**
     * https://www.simplifiedcoding.net/android-volley-tutorial-to-get-json-from-server/
     * Android Volley Tutorial to Get JSON from Server
     * @param savedInstanceState
     */

    private final String TAG = "MyLogs";

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
}
