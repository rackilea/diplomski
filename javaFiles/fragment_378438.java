Button deleteButton = (Button) convertView.findViewById(R.id.delete_button);
    deleteButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            allFavorite.remove(position);
            notifyDataSetChanged();
        }
    });