class RequestTask extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... uri) {
        HttpClient httpclient = getNewHttpClient();
        HttpResponse response;
        String add = "{\"MemberNo\":\"" + uri[0] + "\"}";
        HttpPost postMethod = new HttpPost(wsdl);// + add
        String responseString = null;
        try {
            postMethod.addHeader("Content-Type", "application/json");
            HttpEntity entity = new StringEntity(add);
            postMethod.setEntity(entity);
            response = httpclient.execute(postMethod);

            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
            } else {
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseString;
    }
  }