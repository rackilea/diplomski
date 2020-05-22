if(!image.equals("default")){


                Picasso.with(Profile.this).load(image).networkPolicy(NetworkPolicy.OFFLINE)
                        .placeholder(R.drawable.default).into(mDisplayImage, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        Picasso.with(Profile.this).load(image).placeholder(R.drawable.default).into(mDisplayImage);

                    }
                });