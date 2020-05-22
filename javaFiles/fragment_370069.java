GridView gridview = (GridView) findViewById(R.id.customgrid);
    gridview.setAdapter(new CustomAdapter(this, osNameList, osImages));
    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch(position){
                case 0:
                    Intent a = new Intent(v.getContext(), FirstActivity.class);
                    startActivity(a);
                    break;
                case 1:
                    Intent b = new Intent(v.getContext(), DefaultActivity.class);
                    startActivity(b);
                    break;
                default:
                    break;
            }

        } });