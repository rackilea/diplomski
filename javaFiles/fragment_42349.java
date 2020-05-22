public class MyClass {

    private Context context;

    public MyClass(Context context) {
        this.context = context;
    }

    public void doVolleyRequest() {

        //...
        Volley.newRequestQueue(context).add(jsonRequest);
    }

}