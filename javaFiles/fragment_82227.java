if (!imageArray.get(position).isEmpty()) {
    manager.DisplayImage(imageArray.get(position), loader, mHolder.img1);
}
else {
    manager.DisplayImage(null, loader, mHolder.img1);
    mHolder.img1.setVisibility(ImageView.GONE);
}