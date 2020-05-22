public void F0_getPhoto(){
    Call<UserDataResponse> getPhoto = mApiService.getImage(
            String.valueOf(mPrefs.getUserID()));
    getPhoto.enqueue(new Callback<UserDataResponse>() {
        @Override
        public void onResponse(Call<UserDataResponse> call, Response<UserDataResponse>response) {
            //    String iserror = response.body().getIserror();

            // Jika login berhasil maka data nama yang ada di response API
            // akan diparsing ke activity selanjutnya.
            UserDataResponse userData = response.body();
            //Creating an String array for the ListView
            String error = userData.getIserror();
            List<Image> images = userData.getImages();
            String[] url = new String[images.size()];

            //looping through all the heroes and inserting the names inside the string array
            if (iserror.equals("false")) {
                for (int i = 0; i < images.size(); i++) {
                    url[i] = images.getimage_Url();
                }

                showPhoto(url);
            }

            @Override
            public void onFailure(Call<UserDataResponse> call, Throwable t){
                Log.e("debug", "onFailure: ERROR > " + t.toString());
            }
        });
    }
}