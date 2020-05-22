public class mainActivity extends Activity {



@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

    ArrayList<List> menuitems = getItems("android", 1); //Call to function to get results from web, you can put variables to pass here

    ListView listView = (ListView) findViewById(R.id.Menu);
    listView.setAdapter(new ListAdapter(this, R.layout.categorymenu, menuitems));

    listView.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {              
          ON CLICK ACTIVITY GOES HERE




        }
    });
}

public ArrayList<List> getItems(String searchTerm, int page) {
    String searchUrl = "URL TO YOUR PHP FILE GOES HERE";

    ArrayList<List> lists = new ArrayList<List>();

    HttpClient client = new  DefaultHttpClient();
    HttpGet get = new HttpGet(searchUrl);

    ResponseHandler<String> responseHandler = new BasicResponseHandler();

    String responseBody = null;
    try{
        responseBody = client.execute(get, responseHandler);
    }catch(Exception ex) {
        ex.printStackTrace();
    }

    JSONObject jsonObject = null;
    JSONParser parser=new JSONParser();

    try {
        Object obj = parser.parse(responseBody);
        jsonObject=(JSONObject)obj;

    }catch(Exception ex){
        Log.v("TEST","Exception: " + ex.getMessage());
    }

    JSONArray arr = null;

    try {
        Object j = jsonObject.get("results");
        arr = (JSONArray)j;
    }catch(Exception ex){
        Log.v("TEST","Exception: " + ex.getMessage());
    }

    for(Object t : arr) {
        List list = new List(
                ((JSONObject)t).get("categories_name").toString(),
                ((JSONObject)t).get("categories_id").toString()
                );
        lists.add(list);
    }

    return lists;


}   

/** Classes **/

public class List {
    public String name;
    public String message;
    public Boolean usernameSet = false;
    public Boolean messageSet = false;

    public List(String username, String message) {
        this.name = username;
        this.message = message;
    }
}

}