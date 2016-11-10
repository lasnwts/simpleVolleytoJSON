package ru.nwts.simplevolleytojson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * https://www.simplifiedcoding.net/android-volley-tutorial-to-get-json-from-server/
     * https://www.dropbox.com/s/vhs7ctj8wmxly2a/json.php?dl=0
     * Android Volley Tutorial to Get JSON from Server
     * @param savedInstanceState
     */

    private final String TAG = "MyLogs";
    public static final String JSON_URL = "https://www.dropbox.com/s/vhs7ctj8wmxly2a/json.php";
    //public static final String JSON_URL = "http://simplifiedcoding.16mb.com/UserRegistration/json.php";

    private Button buttonGet;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"MainActivity Started");

        buttonGet = (Button) findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listView);



    }

    private void sendRequest(){
      //  StringRequest stringRequest = new StringRequest(JSON_URL, listener, errorlistener);

        Log.d(TAG,"MainActivity sendRequest start");

        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG,"MainActivity Response onResponse");
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG,"MainActivity Response onErrorResponse");
                        Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){

            Log.d(TAG,"MainActivity showJSON");
        if (json == null){
            Toast.makeText(MainActivity.this,"json resoponse return nill",Toast.LENGTH_LONG).show();;
            Log.d(TAG,"MainActivity json response return null.");
        }

            ParseJSON pj = new ParseJSON(json);
            pj.parseJSON();
            Log.d(TAG, "parsejson:"+json.toString());
        Log.d(TAG, "parsejson:----------------");

            CustomList cl = new CustomList(this, ParseJSON.ids,ParseJSON.names,ParseJSON.emails);
            listView.setAdapter(cl);

    }

    public void test(){
      int i = 1;
    }

    @Override
    public void onClick(View view) {
        sendRequest();
    }
}
