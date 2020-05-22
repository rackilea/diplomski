private class methodName extends
            AsyncTask<String, Integer, byte[]> {

        @Override
        protected byte[] doInBackground(String... params) {
            String uri = params[0];
            try {

                MultipartEntityBuilder entity;
                File f;
                FileBody fb;
                entity = MultipartEntityBuilder.create();

                entity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                f = new File(zipImageFile);
                fb = new FileBody(f);
                entity.addPart("orderFile", fb);
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(uri);
                Log.e("Uploload Missing Image URL", "" + uri);
                httppost.setEntity(entity.build());
                HttpResponse response = httpclient.execute(httppost);
    //              byte[] fileBites=null;
               BufferedInputStream bufferedInputStream;
               ByteArrayOutputStream byteArrayOutputStream;
                byte[] buffer = new byte[5 * 1024];
                int numRead = -1;
                while( (numRead = bufferedInputStream.read(buffer))!= -1)
                {
                    byteArrayOutputStream.write(buffer, 0, numRead);
                }
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byte[] result = byteArrayOutputStream.toByteArray();

    //              fileBites=stringBuffer.toString().getBytes();
    //              Log.e("FILE BITES", fileBites+"=>"+fileBites.length);



                return ;

    //              return stringBuffer.toString();
            } catch (Exception e) {
                return e.toString().getBytes();
            }

        }

        @Override
        protected void onPostExecute(byte[] result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            Log.e("Response From Server", "" + result);
            writeToFile(result);

        }

    }


    private void writeToFile(byte[] data) {
        try {

            FileOutputStream fop = null;
            File file;

            file = new File(AppConstants.DataPath+"/products.zip");
            fop = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            try {            
            fop.write(data);

        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        unzipImage(AppConstants.DataPath + "/products.zip",
                AppConstants.DataPath);
    }catch (Exception E)
    {

    }
    }