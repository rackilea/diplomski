@Override
public View getView(final int position, View convertView, ViewGroup parent) {

      ViewHolder holder=null;
      View view = convertView; 
      ContactItem contactItem = getItem(position);
      LayoutInflater mInflater = (LayoutInflater) context
             .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
           view = mInflater.inflate(R.layout.contact_list, null);
            holder = new ViewHolder();
            holder.tv1 = (TextView) view.findViewById(R.id.name);
            holder.tv2 = (TextView) view.findViewById(R.id.number);
            holder.ch = (CheckBox) view.findViewById(R.id.checkbox1);
            view.setTag(holder);
        } else {
          holder = (ViewHolder) view.getTag();
        }

       holder.tv1.setText(contactItem.getConatct_name());
       holder.tv2.setText(contactItem.getNumber());

       holder.ch.setOnCheckedChangeListener(null);
       holder.ch.setChecked(contactItem.getCheckedStatus());
       holder.ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    contactItem.setCheckedStatus(isChecked);
                }
            });
       return view;

     }