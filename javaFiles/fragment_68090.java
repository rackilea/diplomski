Glide.with(getApplicationContext())
    .load(photoUrl)
    .centerCrop()
    .transform(new CircleTransform(getApplicationContext()))
    .override(45,45)
    .into(imageView);