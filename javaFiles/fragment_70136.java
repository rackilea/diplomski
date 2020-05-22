final TextView displayInteger = (TextView) convertView.findViewById(R.id.integer_number);
    int count = sia.get(position);
    displayInteger.setText("" + count);
    decrease.setEnabled(count > 0);

    increase.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int count = sia.get(position);
            count++;
            sia.put(position, count);
            notifyDataSetChanged();
        }
    });
    decrease.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int count = sia.get(position);
            count--;
            sia.put(position, count);
            notifyDataSetChanged();
        }
    });