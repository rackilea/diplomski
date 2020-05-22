gv.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v,
                int position, long id) {

        if(position==0){
            Intent iinent= new Intent(MyActivity.this,secondactivity.class);
            startActivity(iinent);
        }

        }
    });