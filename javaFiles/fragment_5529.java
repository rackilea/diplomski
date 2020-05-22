LayoutInflater inflater = context.getLayoutInflater();
View view = (convertView == null)? inflater.inflate(R.layout.list_item_ex, parent, false) : convertView;

holder = new ViewHolder();
holder.txtViewTitle = (TextView) convertView.findViewById(R.id.tv_adapter_title);
holder.txtViewTime = (TextView) convertView.findViewById(R.id.tv_adapter_time_get);
holder.txtViewPodh = (TextView) convertView.findViewById(R.id.tv_adapter_podh_get);
holder.txtViewCount = (TextView) convertView.findViewById(R.id.tv_adapter_count_get);
holder.txtViewWeight = (TextView) convertView.findViewById(R.id.tv_adapter_weight_get);
holder.txtViewTitle.setText(list.get(position).getTitle().toString());
holder.txtViewTime.setText(String.valueOf(list.get(position).getTime()));
holder.txtViewPodh.setText(String.valueOf(list.get(position).getPodh()));
holder.txtViewCount.setText(String.valueOf(list.get(position).getCount()));
holder.txtViewWeight.setText(String.valueOf(list.get(position).getWeight())); 

return view;