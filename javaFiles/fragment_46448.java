HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(urlString);


        try {
            CustomMultiPartEntity entity=new CustomMultiPartEntity(new CustomMultiPartEntity.ProgressListener() {

                @Override
                public void transferred(long num) {
                    publishProgress((int) ((num / (float) totalSize) * 100));
                }
            });

            entity.addPart("FirstName", new StringBody(Person.getFirstName()));
            entity.addPart("LastName", new StringBody(Person.getLastName()));
            entity.addPart("Email", new StringBody(Person.getEmail()));
            entity.addPart("Password", new StringBody(Person.getPassword()));
            entity.addPart("Mobilenumber", new StringBody(Person.getMobilenumber()));
            entity.addPart("uploadedfile", new FileBody(sourceFile));
            totalSize = entity.getContentLength();
            httppost.setEntity(entity);
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity r_entity = response.getEntity();
            responseString = EntityUtils.toString(r_entity);

        } catch (ClientProtocolException e) {
            responseString = e.toString();
        } catch (IOException e) {
            responseString = e.toString();
        }