...
mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache()) {
    @Override
        protected Request<Bitmap> makeImageRequest(String requestUrl, int maxWidth, int maxHeight,
                    ScaleType scaleType, final String cacheKey) {
                return new ImageRequest(requestUrl, new Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        onGetImageSuccess(cacheKey, response);
                    }
                }, maxWidth, maxHeight, scaleType, Config.RGB_565, new ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        onGetImageError(cacheKey, error);
                    }
                }){
          @Override
                    public Response<Bitmap> parseNetworkResponse(NetworkResponse response) {
                        Response<Bitmap> resp = super.parseNetworkResponse(response);
                        if(!resp.isSuccess()) {
                            return resp;
                        }
                        long now = System.currentTimeMillis();
                        Cache.Entry entry = resp.cacheEntry;
                        entry.ttl = now + 30l * 24 * 60 * 60 * 1000;  //keeps cache for 30 days
                        return Response.success(resp.result, entry);
                    }

        };
            }
};
    ...