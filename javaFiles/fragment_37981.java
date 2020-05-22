public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_edit, parent, false);

            holder = new ViewHolder();
            holder.chBoxUcast = (CheckBox) convertView
                    .findViewById(R.id.checkBox_person);
            holder.edTBonus = (UpgEditText) convertView
                    .findViewById(R.id.bonus);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.edTBonus.setOnTextChangedListener(position, this);
        holder.chBoxUcast
                .setOnCheckedChangeListener(new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        // TODO Auto-generated method stub
                        itemsArrayList.get(position).setUcast(isChecked);
                    }
                });

        holder.chBoxUcast.setText(itemsArrayList.get(position).getMeno());
        holder.chBoxUcast.setChecked(itemsArrayList.get(position).getUcast());
        holder.edTBonus.setText(Integer.toString(itemsArrayList.get(position)
                .getBonus()));

        return convertView;

    }