private void uploadVideo(String yourfilepath) throws ParseException, IOException {

                HttpClient httpclient = new DefaultHttpClient();

                //post request to send the video 
                HttpPost httppost = new HttpPost("your link to uploadd");
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy( policy);
                FileBody video_file1 = new FileBody(new File(videoPath));
                MultipartEntity reqEntity = new MultipartEntity();
                reqEntity.addPart("your argument that your server take", video_file1);                    
                httppost.setEntity(reqEntity);

                // DEBUG
                System.out.println( "executing request " + httppost.getRequestLine( ) );
                HttpResponse response = httpclient.execute( httppost );
                HttpEntity resEntity = response.getEntity( );

                // DEBUG
                System.out.println( response.getStatusLine( ) );
                if (resEntity != null) {
                  System.out.println( EntityUtils.toString( resEntity ) );
                } // end if
                if (resEntity != null) {
                  resEntity.consumeContent( );
                } // end if

                httpclient.getConnectionManager( ).shutdown( );
            }