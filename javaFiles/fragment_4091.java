textView.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        Picasso.withContext(context).download(...).into(imageView).etc();
        textView.setVisiblity(View.GONE);
        imageView.setVvisibility(View.VISIBLE);
    }
});