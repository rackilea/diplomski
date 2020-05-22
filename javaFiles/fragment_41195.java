protected static class ViewHolder extends RecyclerView.ViewHolder {
    protected ImageView image;
    public ViewHolder(View view) {
        super(view);

        // Set the proper layout id cover_image here
        this.image = (ImageView) view.findViewById(R.id.cover_image);
    }
}