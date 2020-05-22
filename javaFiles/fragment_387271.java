holder.root.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(NtindaCinemaAdapter.this.context, MovieScrollingActivity.class);
        Bitmap attachedbitmap= ((BitmapDrawable) holder.moviepic.getDrawable()).getBitmap();
        intent.putExtra("image",encodeTobase64(attachedbitmap)); 
    }
});