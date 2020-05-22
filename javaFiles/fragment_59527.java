public class Task_TurnoutPost extends AsyncTask<Void, Void, Void> {
        private final ProgressDialog dialog = new ProgressDialog(ActivityName.this);
        JSONObject object_feed;
        // can use UI thread here
        protected void onPreExecute() {
            this.dialog.setMessage("Loading...");
            this.dialog.setCancelable(false);
            this.dialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            try {

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost postRequest = new HttpPost("Your LINK");
                MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
                reqEntity.addPart("F_Name", new StringBody("F_Name"));
                reqEntity.addPart("L_Name",new StringBody("L_NAME"));
                try{
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bitmap.compress(CompressFormat.JPEG, 75, bos);
                    byte[] data = bos.toByteArray();
                    ByteArrayBody bab = new ByteArrayBody(data, "forest.jpg");
                    reqEntity.addPart("picture", bab);
                }catch(Exception e){
                    //Log.v("Exception in Image", ""+e);
                    reqEntity.addPart("picture", new StringBody(""));
                }

                postRequest.setEntity(reqEntity);
                HttpResponse response = httpClient.execute(postRequest);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                String sResponse;
                StringBuilder s = new StringBuilder();
                while ((sResponse = reader.readLine()) != null) {
                    s = s.append(sResponse);
                }
                object_feed = new JSONObject(s.toString());
                success_response=object_feed.getString("status");
                Log.v("Response for POst", s.toString());
            } catch (Exception e) {
                Log.e("e.getClass().getName()", ""+e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
        }

    }