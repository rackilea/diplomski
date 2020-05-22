public View getView(int position, View convertView, ViewGroup parent) {

    ImageView imageView = null;

    if (convertView == null) {
        imageView = new ImageView(this.mContext);
    } else {
        imageView = (ImageView) convertView;
    }

    // clean up your old bitmap first, if there is one.
    if(imageView.getDrawable() instanceof BitmapDrawable){
        BitmapDrawable bd = (BitmapDrawable) imageView.getDrawable();
        imageView.setDrawable(null);
        if(bd.getBitmap() != null){
            bd.getBitmap().recycle();
        }
        bd = null;
    }

    new BitmapWorkerTask(imageView).execute(Tattoos[position]);


    return imageView;
}