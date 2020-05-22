Picasso.with(context)
    .load(image)
    .error(android.R.drawable.stat_notify_error)
    .placeholder(R.drawable.ic_blu_logo)
    .fit()
    .centerCrop()
    .into(postImage);