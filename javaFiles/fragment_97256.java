for (final GalleryItem item : items) {
    ImageView iv = new ImageView(context);
    LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT
                                            , LayoutParams.WRAP_CONTENT);

     param.setMargins(0, 0, 10, 0);
     iv.setLayoutParams(param);
     iv.setImageBitmap(item);
     iv.setAdjustViewBounds(true);
     layout.add(iv);   //your gallery layout
}