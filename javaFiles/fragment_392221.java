if (v == null) {
            holder = new ViewHolder();
            //LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.trans_item, parent, false);

            holder.txtViewAmount = (TextView) convertView.findViewById(R.id.trans_amount);
            holder.txtViewDate = (TextView) convertView.findViewById(R.id.trans_date);
            holder.txtViewTitle = (TextView) convertView.findViewById(R.id.trans_title);

            convertView.setTag(holder);
        }