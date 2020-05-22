final Dialog progressDialog = ProgressDialog.show(this, title, message);
//Should use DialogFragment to wrap the ProgressDialog

new AsyncTask<String, Void, List<byte[]>>(){

    @Override
    protected List<byte[]> doInBackground(String... urls) {
        List<byte[]> imageList = new ArrayList<byte[]>();
        HttpURLConnection conn = null;
        byte[] buffer = new byte[BUFF_SIZE];
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream(BUFF_SIZE);
        //Add try - catch - finally block
        for(String targetUrl : urls){
            conn = (HttpURLConnection)new URL(targetUrl).openConnection();
            InputStream iStream = new BufferedInputStream(conn.getInputStream());
            int len = 0;
            //Alternatively could use Apache Commons IO
            while ((len = iStream.read(buffer)) >= 0) {
               byteBuffer.write(buffer, 0, len);
            }
            imageList.add(byteBuffer.toByteArray());
            byteBuffer.reset();
        }
        return imageList;
    }

    @Override
    protected void onPostExecute(List<byte[]> result) {
        progressDialog.dismiss();
        listView.setAdapter(new ImageAdapter(result)); //Example
        super.onPostExecute(result);
    }

}.execute(imageUrl1, imageUrl2, imageUrl3);