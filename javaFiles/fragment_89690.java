lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            //here is the onClick where you should be able to make call
            String person_number = ((TextView) view.findViewById(android.R.id.text2)).getText().toString();
        }
    });