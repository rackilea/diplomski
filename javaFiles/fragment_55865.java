public class VolleyGetHeaders {
private static final String TAG = "VolleyGet";
private static VolleyGetHeaders instance = null;
public RequestQueue requestQueue;
String finalToken;

private VolleyGetHeaders(Context context,String finalToken)
    {
    this.context=context;
    this.finalToken=finalToken;
    requestQueue = Volley.newRequestQueue(context.getApplicationContext());

    return;
    }