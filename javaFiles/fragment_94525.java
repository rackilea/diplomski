lv.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> arg0, View view, int arg2,long itemID) {

       Intent in = new Intent(getApplicationContext(),Detail.class);
       in.putExtra("data", Series.getLista().get(itemID));
       startActivity(in);
    }
});