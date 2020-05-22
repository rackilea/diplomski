if (!imageArray.get(position).isEmpty()) {
    mHolder.img1.setVisibility(ImageView.VISIBLE);
    manager.DisplayImage(imageArray.get(position), loader, mHolder.img1);
}
else {
    manager.DisplayImage(null, loader, mHolder.img1);
    mHolder.img1.setVisibility(ImageView.GONE);
}