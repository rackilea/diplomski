private class MyCursorAdapter extends SimpleAdapter {

//private variables
    Context context;
    LayoutInflater inflater;
        public MyCursorAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
         this.context = context;
//get layoutinflater
         inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            Set<Integer> VALUES = new HashSet<Integer>(Arrays.asList(
                    new Integer[]{0, 1, 2, 3, 4, 5, 10, 15, 20}
            ));

//inflate your layout
           if(convertView==null)
    {
          convertView = inflater.inflater(layoutfile, parent,false);
    }     


            if (VALUES.contains(Integer.valueOf(position))) {
                convertView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                TextView tv = (TextView) convertView.findViewById(R.id.statistic_cell_text);
                tv.setTextColor(getResources().getColor(R.color.statistic_title));
                convertView.setPadding(0, 0, 0, 0);
            } else {
                convertView.setBackground(getResources().getDrawable(R.drawable.border_intern));
            }
            return convertView;
        }
    }