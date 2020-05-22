private class MyAdapter extends BaseAdapter{

        private List<Data> data;
        private LayoutInflater inflater;
        private TextView text;

        public MyAdapter(Data[] contents){
            data = new ArrayList<Data>();
            for(Data d : contents){
                data.add(d);
            }
            inflater = getLayoutInflater();

        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = inflater.inflate(R.layout.row, null);
            }
            if(data != null){
                text = (TextView) convertView.findViewById(R.id.textView1);
                text.setText(data.get(position).getName());
            }
            return convertView;
        }


        @Override
        public int getCount() {
            return data.size();
        }


        @Override
        public Object getItem(int arg0) {
            return data.get(arg0);
        }


        @Override
        public long getItemId(int position) {
            return data.get(position).hashCode();
        }

    }
}