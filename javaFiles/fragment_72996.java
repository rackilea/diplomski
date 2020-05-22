@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_code, null);
            holder = new ViewHolder();

            holder.member_name = (TextView) convertView
                    .findViewById(R.id.member_name);
            holder.contactType = (TextView) convertView
                    .findViewById(R.id.contact_type);



            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
// put here ..... after else condition
            RowCode row_pos = rowItems.get(position);

            holder.member_name.setText(row_pos.getMember_name());
            holder.contactType.setText(row_pos.getContactType());

    return convertView;
    }