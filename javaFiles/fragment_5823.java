listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            /*//listview clicked item index
            int itemPosition = position;

            //Listview clicked item value
            String itemValue = (String)listView.getItemAtPosition(position);

            //show alert
            Toast.makeText(getApplicationContext(),
                    "Position:"+itemPosition+" ListItem:" + itemValue, Toast.LENGTH_LONG).show();*/
            switch(itemPosition)    

            case 0 :Intent appInfo = new Intent(About.this, about_app.class);
                startActivity(appInfo);
             break;
            case 1 :Intent appInfo = new Intent(About.this, Activity1.class);
                startActivity(appInfo);
             break;
             case 2 :Intent appInfo = new Intent(About.this, Activity2.class);
                startActivity(appInfo);
             break;
        }
    });