protected void onCreate(Bundle savedInstanceState) {
   //TODO Auto-generated method stub
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);
   context=this;
   records=new ArrayList<String>();
   listProduct=(ListView)findViewById(R.id.product_list);


 BackTask bt=new BackTask();
       bt.execute();


   adapter=new CustomAdapter(context, R.layout.list_item,R.id.pro_name, records);
   listProduct.setAdapter(adapter);
   listProduct.setOnItemClickListener(new OnItemClickListener(){
       @Override
       public void onItemClick(AdapterView<?> arg0, View v, int position, long id){

           String sText = ((TextView) v.findViewById(R.id.pro_name)).getText().toString();
           Intent songIntent = new Intent(getApplicationContext(), SongActivity.class);
           songIntent.putExtra("movie_name", sText );
           startActivity(songIntent);

       }

   });
   }