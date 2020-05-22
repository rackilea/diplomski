public class ParseJsonAndroidExample extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_parse_json_android_example);


    final Spinner output = (Spinner) findViewById(R.id.output);
    final Button bparsejson      = (Button) findViewById(R.id.bparsejson);
    String OutputData ;
    ArrayList<String> outputDataList  = new ArrayList<String>();


    /************  Static JSON data ***********/
    final String strJson = "{ "Android" :[{"id":"1",
                                      "client_name":"Glasco Smith Klin",
                                      "campaign_name":"Health Medicine Survay",
                                      "question":"MODE OF COMPLAINT CAN BE GIVEN THROUGH __________________",
                                        "option_A":"WRITTEN",
                                         "option_B":"ORAL",
                                       "option_C":"PHONE CALL",
                                        "option_D":"ALL OF THE ABOVE",
                                        "q_prefix":"GSKHMSQ"},

                                         {"id":"2",
                                          "client_name":"Glasco Smith Klin",
                                           "campaign_name":"Health Medicine Survay",
                                           "question":"ADDING NEW FIR CAN BE DONE FROM WHICH ROLE",
                                            "option_A":"IO",
                                             "option_B":"TRAFFIC",
                                             "option_C":"SHO-CRIME",
                                             "option_D":"ADMINISTRATOR",
                                              "q_prefix":"GSKHMJD"}] }";


    /******** Listener for button click ********/
    bparsejson.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {

           String OutputData = "";
           JSONObject jsonResponse;

           try {

                /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
                jsonResponse = new JSONObject(strJson);

                /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
                /*******  Returns null otherwise.  *******/
                JSONArray jsonMainNode = jsonResponse.optJSONArray("Android");

                /*********** Process each JSON Node ************/

                int lengthJsonArr = jsonMainNode.length();  

                for(int i=0; i < lengthJsonArr; i++) 
                {
                    /****** Get Object for each JSON node.***********/
                    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                    /******* Fetch node values **********/
                    int id        = Integer.parseInt(jsonChildNode.optString("id").toString());
                    String client_name   = jsonChildNode.optString("client_name").toString();
                    String campaign_name=    jsonChildNode.optString("campaign_name").toString();
                   String question= jsonChildNode.optString("question").toString();
                   String option_A= jsonChildNode.optString("option_A").toString();

String option_B= jsonChildNode.optString("option_B").toString();
String option_C= jsonChildNode.optString("option_C").toString();
 String option_D= jsonChildNode.optString("option_D").toString(); 
String q_prefix= jsonChildNode.optString("q_prefix").toString();


                    OutputData += "Node : \n\n     "+ id +" | "
                                                        + client_name+" | "
                                                        + campaign_name+" 
                                                         + question+" | "
                                                         + option_A+" | "
                                                         + option_B+" | "
                                                         + option_C+" | "
                                                          + option_D+" | "
                                                          + q_prefix+" | " +"\n\n ";




               }
              outputDataList.add(OutputData);


                /************ Show Output on Spinner **********/

       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item ,outputDataList  );
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    codeSpinner.setAdapter(adapter);



            } catch (JSONException e) {

                e.printStackTrace();
            }

        }
    });
 }
}