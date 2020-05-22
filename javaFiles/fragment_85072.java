view.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        item.setSelected(!item.isSelected());
        notifyDataSetChanged();
    }
});