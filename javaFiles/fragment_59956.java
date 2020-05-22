listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

           if(position == 0){

            startActivity(new Intent(MainActivity.this, games.class));

           }else
           {
              startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Coffee")));
           }

        }
    });