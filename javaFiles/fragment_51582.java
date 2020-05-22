Picasso.with(mContext)
.load(uploadCurrent.getImageUrl())
.error(R.drawable.error_image)
.into(holder.imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                       // will load image 
                    }

                    @Override
                    public void onError() {
                       // will not load image from url
                    }
                });