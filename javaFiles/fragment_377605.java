HashMap<String, Class>hashMap=new HashMap<String, Class>();


  hashMap.put("Niat",NiatActivity.class);
  hashMap.put("Lafaz",LafazActivity.class);
  hashMap.put("Solat",SolatActivity.class);
   lv.setOnItemClickListener(new OnItemClickListener() {

        public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
   String openClass = adapter.getItem(position);
   Intent myIntent1 = new Intent(MainTwoActivity.this,
              hashMap.get(openClass));
            startActivity(myIntent1);
  }