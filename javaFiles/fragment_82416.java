@Override
public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String text = holder.editText.getText().toString();
        }
    });
}