gridView.setOnItemClickListener(new OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        ImageView image = (ImageView) v.findViewById(R.id.image);;
        image.setClickable(false);
        image.setImageResource(R.drawable.skin_x);
        TextView text = (TextView) v.findViewById(R.id.text)
        Toast.makeText(getApplicationContext(), text.getText(), Toast.LENGTH_SHORT).show();
    }
});