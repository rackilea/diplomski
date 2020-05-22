ImageButton btn_image = (ImageButton) itemview.findViewById(R.id.delete);
btn_image.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        View parentItem = view.getParent();
    }
});