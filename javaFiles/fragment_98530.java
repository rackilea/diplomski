entity.addPart("user_id", new StringBody(user_id));
            Log.d("userid",user_id);
            entity.addPart("username", new StringBody(username));
            entity.addPart("password", new StringBody(password));
            entity.addPart("filetype",new StringBody("jpeg"));
            // entity.addPart("photo", new
            // StringBody("/storage/sdcard0/Download/1.jpg"));
            httpPost.setEntity(entity);

            Log.d("URL Request: ", url.toString());

            HttpResponse httpResponse = httpClient.execute(httpPost);
            int code = httpResponse.getStatusLine().getStatusCode();