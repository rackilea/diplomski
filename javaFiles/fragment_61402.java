public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
    holder.textView.setText(Text.get(i));
    holder.ParentLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: Click on this card !");
        }
    });
}