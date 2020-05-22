Call<PhotosWrapper> call = service.getRecentPhotos(METHOD, API_KEY, FORMAT, NOJSONCALLBACK, EXTRAS);

@Override
public void onResponse(Response<PhotosWrapper> response, Retrofit retrofit) {
    // should do some more error checking here (check isSuccess() and null checks
    mPhotos = response.body().photos.photo;
}