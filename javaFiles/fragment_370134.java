ArrayAdapter adapter=new ArrayAdapter(
            this, android.R.layout.simple_list_item_1, listItems){

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view =super.getView(position, convertView, parent);

            TextView textView=(TextView) view.findViewById(android.R.id.text1);
            textView.setTextColor(Color.BLACK);

            return view;
        }
    };
    recentlist.setAdapter(arrayAdapter);