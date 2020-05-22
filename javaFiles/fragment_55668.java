// postData = your json data

    ByteArrayEntity entity = null;
    try {
        entity = new ByteArrayEntity(postData.toString().getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

    entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

    asyncHttpClient.post(getActivity(), url, entity, "application/json", new AsyncHttpResponseHandler() {