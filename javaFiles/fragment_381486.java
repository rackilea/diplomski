private MyAdapter ma;

onCreate(){
    ...
    setContentView(R.layout.activty_main2);
    lv = (ListView) findViewById(R.id.lv_1);
    ma = new MyAdapter(this, arr);
    lv.setAdapter(ma);
    initData();
}

initData(){
    for(;;){
        ...
        arr.add(n);     
    }
    ma.noftifyDataSetChanged();
}