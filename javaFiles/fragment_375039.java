listView.setOnItemClickListener(new OnItemClickListener(){

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {

        /* THIS IS WHAT YOU WANT TO DO TO GET AN ITEM FROM YOUR LIST */
        String data = dataAdapter.getItem(position);

        // do what you want with your data String
    }

});