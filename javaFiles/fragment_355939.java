httpResponse = client.execute(post, _httpContext);
        //Set the response code from the request's responst.
        setResponseCode(httpResponse.getStatusLine().getStatusCode());
        //Retrieve the body of the response.
        entity = httpResponse.getEntity();

        if(entity != null) {
            //Retrieve the content from the body.
            _inStream = entity.getContent();
            //Convert the InputStream to String and set the String response to the returned value.
            setStringResponse(IOUtility.convertStreamToString(_inStream));
            //Close the InputStream.
            Log.d(TAG, getStringResponse());
        }