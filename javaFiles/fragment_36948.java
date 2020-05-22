public void getUserPhotoLink(int user_id,final Callbacks callback){

 request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onError(VKError error) {
              callbacks.failCallback("fail");
            }

           @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                //Your code
               callback.successCallback(user.photo_100);

            }