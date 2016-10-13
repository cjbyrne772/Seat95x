package com.seatstir.andy.seat95;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by fred on 11/11/2015.
 */

    import org.json.JSONObject;

        import android.app.ProgressDialog;
        import android.content.Context;
        import android.widget.TextView;

        import com.android.volley.Request.Method;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonObjectRequest;

import java.util.HashMap;
import java.util.Map;

public class RequestJSON {
    Context context;
    TextView display;

    public RequestJSON(Context con, TextView tv) {
        context = con;
        display = tv;
    }

    public void requestJSON(String url) {
        // Tag used to cancel the request
        String tag_json_obj = "json_obj_req";

        final ProgressDialog pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url,
                (String)null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                display.setText(response.toString());
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

        } ;

        // Adding request to request queue
        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjReq,
                tag_json_obj);
    }

}