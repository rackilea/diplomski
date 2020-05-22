listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, list.items)
            {
                @Override
                public View getView(final int position, View convertView, ViewGroup parent)
                {
                    View view = super.getView(position, convertView, parent);
                    String entry = list.items.get(position);
                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    text1.setText(entry);
                    return view;
                }
            });