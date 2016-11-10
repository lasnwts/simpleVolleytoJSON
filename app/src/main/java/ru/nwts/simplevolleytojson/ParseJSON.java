package ru.nwts.simplevolleytojson;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.R.attr.id;

/**
 * Created by Надя on 09.11.2016.
 */

public class ParseJSON {

    private final String TAG = "MyLogs";

    public static String[] ids;
    public static String[] names;
    public static String[] emails;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            Log.d(TAG,"try parserJSON");

            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);
            Log.d(TAG,"users count==");
            Log.d(TAG,"users count:"+users.length());

            ids = new String[users.length()];
            names = new String[users.length()];
            emails = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);
                emails[i] = jo.getString(KEY_EMAIL);
            }
            if (users == null){
                Log.d(TAG, "users null!");
                ids = new String[1];
                names = new String[1];
                emails = new String[1];



                ids[0] = "0";
                names[0] = "empty";
                emails[0] = "non files";

            }
        } catch (JSONException e) {
            Log.d(TAG,"users count==JSONException");

            ids = new String[1];
            names = new String[1];
            emails = new String[1];


            ids[0] = "0";
            names[0] = "empty";
            emails[0] = "non files";
            e.printStackTrace();
        }
    }
}
