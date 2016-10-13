package com.seatstir.andy.seat95;

        import android.app.Activity;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.KeyEvent;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.inputmethod.EditorInfo;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.ScrollView;
        import android.widget.TextView;
        import android.widget.Toast;

     //   import com.seatstir.andy.eventlistlib.EventList;

      //  import org.apache.http.NameValuePair;
      //  import org.apache.http.client.entity.UrlEncodedFormEntity;
      //  import org.apache.http.message.BasicNameValuePair;
        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonObjectRequest;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.UnsupportedEncodingException;
        import java.net.URL;
        import java.net.URLEncoder;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

    //    import com.seatstir.andy.eventlistlib.EventList;

    //    import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends Activity {

        TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            tv = (TextView) findViewById(R.id.textView);
            // String urlString = "https://seatstir.com/ptapp/jsontest.php";
            String urlString = "https://seatstir.com/ptapp/ptlogin.php";
            // String urlString = "https://httpbin.org/post";
            //  String urlString = "http://api.androidhive.info/volley/person_object.json";
        Toast.makeText(MainActivity.this, "starting1", Toast.LENGTH_SHORT).show();


// Get a RequestQueue. If the VolleySingleton has not been created, this will
// new it and return a pointer to the instance
        RequestQueue queue = VolleySingleton.getInstance(this.getApplicationContext()).
                getRequestQueue();
            // We don't need to have the queue here. Just get a string from the network
            // with networkStringLoader
        Toast.makeText(MainActivity.this, "starting", Toast.LENGTH_SHORT).show();

        NetworkStringLoader loader = new NetworkStringLoader(MainActivity.this, tv);
            String jstr = loader.requestString(urlString);
        ///////////////////////////////////////////////////
        if (jstr.indexOf("success") != -1) {
            // Toast.makeText(getApplicationContext(), "Good Login", Toast.LENGTH_LONG).show();
            // Toast.makeText(getApplicationContext(), "user " + mUser + " pw " + mPass , Toast.LENGTH_SHORT).show();
            //  startActivity(new Intent(getApplicationContext(), Events.class));
            // Toast.makeText(getApplicationContext(), "StartAct", Toast.LENGTH_LONG).show();
            //  Intent intent_name = new Intent();
            //  intent_name.setClass(getApplicationContext(), Events.class);
            //  startActivity(intent_name);
            /////////////////////
        //    Intent i = new Intent(getApplicationContext(), EventList.class);
        //    i.putExtra("jstr", jstr);
        //    startActivity(i);
            Toast.makeText(MainActivity.this, "Login ok" + jstr, Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(MainActivity.this, "Login Failed Try Again" + jstr, Toast.LENGTH_SHORT).show();
        }
////////////////////////////////////////////////////////////////////////
        // We're going to dump the JSON request - it seems it is impossible, at this time,
        // to send POST data to the volley json request. This is hard to believe, but
        // it is backed up by numerous posts to StackOverflow etc.
        //    RequestJSON req = new RequestJSON(MainActivity.this, tv);
        //    req.requestJSON(urlString);
           // loader.requestString(urlString);

         //   RequestJSON req = new RequestJSON(MainActivity.this, tv);
         //   req.requestJSON(urlString);
    }
}