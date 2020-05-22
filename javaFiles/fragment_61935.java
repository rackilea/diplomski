imagine = findViewById(R.id.imagine);
Picasso picasso = new Picasso.Builder(parent.getContext())
            .listener(new Picasso.Listener() {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                    // check here the exception
                }
            })
            .build();

picasso.load("http://i.imgur.com/DvpvklR.png")
            .into(imagine);