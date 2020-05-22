@Override
        public View getView(final int position, View convertView, ViewGroup parent) {

   ... 

    @Override
        public void onClick(View v) {
            ViewHolder holder = (ViewHolder) v.getTag();
            for (int i = 0; i < icons.size(); i++) {
                if (i == position)
                    icons.get(i).isChecked = true;
                else
                    icons.get(i).isChecked = false;
            }
            getDialog().dismiss();
        }