private class EfficientAdapter extends BaseAdapter {
            private LayoutInflater mInflater;
            private String[] attitude_names;
            public String[] attitude_values;
            private String name;

            public EfficientAdapter(Context context) {
                mInflater = LayoutInflater.from(context);
                attitude_names = context.getResources().getStringArray(R.array.COMP_ATTITUDE_NAME);
                attitude_values = new String[attitude_names.length];
            }

            public Object getItem(int position) {
                return position;
            }

            public long getItemId(int position) {
                return position;
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                final ViewHolder holder;

                if (convertView == null) {
                    convertView = mInflater.inflate(R.layout.addcomp_attitude_row, null);

                    holder = new ViewHolder();
                    holder.Attitude_Name = (TextView) convertView.findViewById(R.id.addcomp_att_name);
                    holder.Attitude_Value = (EditText) convertView.findViewById(R.id.addcomp_att_value);
                    holder.Attitude_Value.addTextChangedListener(new TextWatcher()
                        {
                            public void afterTextChanged(Editable edt) 
                            {
                                attitude_values[holder.ref] = edt.toString();
                            }

                            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

                            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                                //attitude_values[ref] = Attitude_Value.getText().toString();
                            }
                        });

                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }


                holder.ref=position;
                holder.Attitude_Name.setText(attitude_names[position]);
                holder.Attitude_Value.setHint(attitude_names[position]);
                holder.Attitude_Value.setText(attitude_values[position]);




                return convertView;
            }

            class ViewHolder {
                TextView Attitude_Name;
                EditText Attitude_Value; 
                int ref;



            }

            @Override
            public int getCount() {
                return attitude_names.length;
            }
        }