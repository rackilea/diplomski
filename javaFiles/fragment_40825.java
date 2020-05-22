import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.Serializable;

public class BDDRequest implements Serializable {
    private final long serialVersionUID = 1L;

    static private Activity activity;
    public String req;

    public BDDRequest() {
    }


    public static void GetRequest(final Context t, UserEmployeeInfo User, final Callback callback) {

        activity = (Activity) t;


        RequestQueue queue = Volley.newRequestQueue(t);
        ParamsSend params = new ParamsSend();

        params.setUser(User);
        ParserJson<ParamsSend> pj = new ParserJson<>(params);


        String strJson;
        try {
            strJson = pj.writeJSON();

        } catch (JsonProcessingException e) {
            strJson = "null";
        }
        final String data = strJson;
        String REST_API_URL = "http://212.227.53.116:8080/WSmartgroom/rest/perso/request";
        Log.d("lol", strJson);
        StringRequest myReq = new StringRequest(Request.Method.PUT,
                REST_API_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("reponse:", response);
                        callback.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("That didn't work!", "Error");
                callback.onError();
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return data.getBytes();
            }
        };
        queue.add(myReq);
    }


    public interface Callback {
        void onSuccess(String response);
        void onError();
    }

}