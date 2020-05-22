Picasso.with(mContext)
                .load(url)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .setIndicatorsEnabled(false)
                .fit().centerInside().placeholder(null)
                .into(imgView, new Callback()
                {
                    @Override
                    public void onSuccess()
                    {
                    }

                    @Override
                    public void onError()
                    {
                        Picasso.with(mContext)
                                .load(url)
                                .fit().centerInside()
                                .into(imgView, new Callback()
                                {
                                    @Override
                                    public void onSuccess()
                                    {
                                    }

                                    @Override
                                    public void onError()
                                    {
                                    }
                                });
                    }
                });