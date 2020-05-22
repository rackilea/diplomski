ListView listView;
    ArrayAdapter<String> adapter;
   // String address = "";
    InputStream is = null;
    String line = null;
    String result = null;
    String[] data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelompok);

        listView = findViewById(R.id.KelompokList);


      getData();

    }

    private void getData(){

        try {
            URL url = new URL("https://ohmybags.id/aliza/Kelompok.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            is = new BufferedInputStream(connection.getInputStream());

        }catch (Exception e){
            e.getMessage();
        }

        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            StringBuilder stringBuilder = new StringBuilder();

            while ((line=bufferedReader.readLine()) != null){
                stringBuilder.append(line+"\n");
            }

            is.close();
            result = stringBuilder.toString();
        }catch (Exception e){
            e.getMessage();
        }

        try{
            JSONArray jsonArray = new JSONArray(result);

            data = new String[jsonArray.length()];

            for (int i=0;i<jsonArray.length();i++){

               JSONObject jsonObject = jsonArray.getJSONObject(i);
                data[i]=jsonObject.getString("nama_kelompok");
            }

      adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
      listView.setAdapter(adapter);


        }catch (Exception e){
            e.getMessage();
        }
    }