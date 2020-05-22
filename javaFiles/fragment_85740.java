searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String queryString = (String)adapterView.getItemAtPosition(position);
            searchView.setQuery(queryString,true);
            Toast.makeText(view.getContext(), "item clicked " + queryString, Toast.LENGTH_LONG).show();
        }
    });