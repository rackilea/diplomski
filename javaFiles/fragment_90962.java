Glide.with(this)
            .load("")
            .apply(new RequestOptions()
                    .placeholder(R.color.colorPrimary)
                    .dontAnimate().skipMemoryCache(true))
            .listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                    spinner.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    spinner.setVisibility(View.GONE);
                    return false;
                }
            })
            .into(imageView);