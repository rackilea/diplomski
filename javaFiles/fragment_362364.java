// Trigger the download of the URL asynchronously into the image view.
Picasso.with(context)
.load(url) // url of your image
.placeholder(R.drawable.placeholder) // drawable to display while downloading the image
.error(R.drawable.error) // drawable in case of failure
.into(imageView); // ImageView where you want to load the picture.