for (int i = 0; i < images.size(); i++) {
    filePath = Uri.fromFile(new File(images.get(i).path));
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200, 200);
    ImageView iv = new ImageView(context); // context mean YourActivity.this or context object
    iv.setLayoutParams(lp);
    //((ViewGroup)imageView.getParent()).removeView(imageView);
    Glide.with(MainActivity.this).load(filePath).override(200,200).crossFade().into(iv);
    linearLayout.addView(iv);
}