package com.seatstir.andy.seat95;

/**
 * Created by fred on 11/10/2015.
 */

import android.content.Context;

        import android.app.ProgressDialog;
        import android.content.Context;
        import android.widget.TextView;

        import com.android.volley.Request.Method;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class NetworkStringLoader {
    Context context;
    TextView display;

    public NetworkStringLoader(Context con, TextView tv) {
        context = con;
        display = tv;
    }

    public String requestString(String url) {
        // Tag used to cancel the request
        String tag_string_req = "string_req";

        final ProgressDialog pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading...");
        pDialog.show();


      //  StringRequest strReq = new StringRequest(Method.GET, url,
                StringRequest strReq = new StringRequest(Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        display.setText(response);
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                display.setText(error.toString());
                pDialog.hide();
            }
        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        // the POST parameters:
                        params.put("login_email", "info@fillaseatcleveland.com");
                        params.put("login_password", "info");
                        return params;
                    }
                };

        // Adding request to request queue
     //   VolleySingleton.getInstance().addToRequestQueue(strReq, tag_string_req);
        VolleySingleton.getInstance(context).addToRequestQueue(strReq, tag_string_req);
        // return tag_string_req;
        return "rstr";
    }

}
