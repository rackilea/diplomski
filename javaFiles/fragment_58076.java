private void getFb()
        {
            fb = new Facebook(Constants.facebookKey);
            String[] arrayOfString = new String[1];
            arrayOfString[0] = "publish_stream";
            fb.authorize(this, arrayOfString, new FBDialogListener());
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) 
        {
            super.onActivityResult(requestCode, resultCode, data);
            fb.authorizeCallback(requestCode, resultCode, data);
        }


        private class FBDialogListener implements Facebook.DialogListener
        {

            public void onComplete(Bundle values)
            {
                Bundle localBundle = new Bundle();
                String str1 = "Myapp";
                String str2 = "This image is by Myapp, app for Android.";
                String str3 = "Download It";
                Object[] arrayOfObject = new Object[6];
                  arrayOfObject[0] = str1;
                  arrayOfObject[1] = str2;
                  arrayOfObject[2] = bitmapUrls.get(currentPosition);
                  arrayOfObject[3] = bitmapUrls.get(currentPosition);
                  arrayOfObject[4] = str3;
                  arrayOfObject[5] = "http://play.google.com/store/apps/details?id=myapp";
                  localBundle.putString("attachment", String.format("{\"name\":\"%s:\",\"href\":\"\",\"caption\":\"\",\"description\":\"%s\",\"media\":[{\"type\":\"image\",\"src\":\"%s\",\"href\":\"%s\"}],\"properties\":{\"%s\":{\"text\":\"Android market\",\"href\":\"%s\"}}}", arrayOfObject));
                  fb.dialog(ImageActivity.this, "stream.publish", localBundle, new PublishDialogListener());

            }

            public void onFacebookError(FacebookError e) {
            }

            public void onError(DialogError e) {                
            }

            public void onCancel() {

            }
        }

        private class PublishDialogListener implements Facebook.DialogListener
        {

            public void onComplete(Bundle values) {
                Toast.makeText(ImageActivity.this,  "Image has been shared"  , Toast.LENGTH_LONG).show();
            }

            public void onFacebookError(FacebookError e) {
            }

            public void onError(DialogError e) {
            }

            public void onCancel() {
            }

        }