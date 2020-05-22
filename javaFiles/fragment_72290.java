public class Checkbox_ProducoptionActivity<country> extends Activity {

        ListView list;
        static Context mContext;
        Button btnSave;  
        List<String> val = new ArrayList<String>();
        ArrayList<HashMap<String, String>> list_kategori ; 
        ArrayList<String> stock_list = new ArrayList<String>();
        ArrayList<String> stock2_list = new ArrayList<String>();
        ProgressDialog pd;   
        EfficientAdapter adapter;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.checkboxproduct_option);
            list = (ListView) findViewById(R.id.ListView01);

            btnSave = (Button)findViewById(R.id.btnSave);
            mContext = this;
             final String id =CheckLogin(); 
             if (id!=""){ 
                 loadproductoption(id);

             }

            btnSave.setOnClickListener(new View.OnClickListener() {  
                public void onClick(View v) {
                    SharedPreferences val_shared = getSharedPreferences("CHECKBOX_SHARED", MODE_WORLD_WRITEABLE);
                    SharedPreferences.Editor cleareditor=val_shared.edit();
                    cleareditor.clear();
                    cleareditor.commit();
                 for (int i = 0; i <list.getCount() ; i++) {
                     View vListSortOrder;
                            vListSortOrder=list.getChildAt(i);     
                            try{
                                TextView textval= (TextView)vListSortOrder.findViewById(R.id.TextView01);
                                CheckBox ckc=(CheckBox)vListSortOrder.findViewById(R.id.chkbox1);
                                EditText edit=(EditText)vListSortOrder.findViewById(R.id.txtbox);
                                if (ckc.isChecked()){
                                      edit.getText().toString();
                                      String temp1 = textval.getText().toString();
                                      Toast.makeText(getApplicationContext(), "fuck"+textval.getText().toString(), Toast.LENGTH_LONG).show();
                                      val.add(temp1);
                                }   
                            }catch (Exception e) {
                                // TODO: handle exception
                            }
                    }
                SharedPreferences customer_ident = getSharedPreferences("CHECKBOX_SHARED", MODE_WORLD_WRITEABLE);
                SharedPreferences.Editor editor=customer_ident.edit(); 
                editor.putString("valuecheck", val.toString()); 
                editor.commit();
              //  Toast.makeText(getApplicationContext(), "ada "+val, Toast.LENGTH_LONG).show();
                Intent prdmenuact = new Intent(getApplicationContext(),CreateManageProductActivity.class);
                prdmenuact.putExtra("idaction", "1"); 
                startActivity(prdmenuact);
                finish();
            } 
            }); 
    }

    public void loadproductoption(String id) {
        listproduct task= new listproduct();
        task.execute(id); 
    } 

    private class listproduct extends AsyncTask<String, Void, String>{

         protected void onPreExecute(){
                pd = new ProgressDialog(Checkbox_ProducoptionActivity.this);
                pd.setMessage("Please wait..");
                pd.setCancelable(false);
                pd.show();
         }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            JSONObject jsonResult   = HttpClientCustom.getRequest(Konfigurasi.strUrl+"api-v1/proop?id_user="+ params[0]);
            return jsonResult.toString();
        } 
        protected void onPostExecute(String result){

            JSONObject jsonResponse=null; 
            JSONArray jObject=null;

             list_kategori = new ArrayList<HashMap<String, String>>();  
             try {
                    jsonResponse    = new JSONObject(new String(result));  
                    if(jsonResponse.getString("status").equals("SUCCESS")) { 
                        if (!jsonResponse.getString("total").equals("0")){ 
                            jObject         = jsonResponse.getJSONArray("resultset"); 
                            for (int i = 0; i < jObject.length(); i++) {  
                                    HashMap<String, String> map = new HashMap<String, String>(); 
                                    map.put("idprd", jObject.getJSONObject(i).getString("id"));
                                    map.put("id_user", jObject.getJSONObject(i).getString("id_user"));
                                    map.put("namepd", jObject.getJSONObject(i).getString("name")); 
                                    list_kategori.add(map);   
                            }  
                            adapter = new  EfficientAdapter(Checkbox_ProducoptionActivity.this,list_kategori );
                            list.setAdapter(adapter); 
                        }  
                         pd.dismiss();    
                    } else if (jsonResponse.getString("status").equals("FAILED")) {
                        pd.dismiss();     
                    }
            } catch (JSONException e) {
             //TODO Auto-generated catch block
                e.printStackTrace();
            }   
            pd.dismiss();    
        } 
    }