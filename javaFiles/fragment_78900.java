ArrayList<String> list =new ArrayList<String>(Arrays.asList(mClubArray)); //declare globally so that u can access it 
ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list);

 MyList.setAdapter(adapter);
    MyList.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getActivity(), "You selected : " + item, Toast.LENGTH_SHORT).show();
            String item = list.get(position);
            list.remove(position);
            adapter.notifyDataSetChanged();

        }
    });