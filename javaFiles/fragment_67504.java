// DownloadImage AsyncTask
    private class DownloadImage extends AsyncTask<String, Void, byte[]> {

        UserData userData;

        public DownloadImage(UserData userData) {
            this.userData = userData;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected byte[] doInBackground(String... URL) {
            try {
                return ViewUtils.getByteFromUrl(new URL(URL[0]));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(byte[] result) {
            File photo = new File(getCacheDir() + "/profile_picture/", "photo.jpg");
            if (photo.exists()) {
                photo.delete();
            }
            try {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(photo));
                bos.write(result);
                bos.flush();
                bos.close();
            } catch (java.io.IOException e) {
                Log.e("PictureDemo", "Exception in photoCallback", e);
            }

        }

    }