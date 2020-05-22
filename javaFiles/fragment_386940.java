HttpGet httpget = new HttpGet("url1");
        client.getCookieStore().getCookies();
        HttpResponse response1 = client.execute(httpget);
        HttpEntity entity1 = response1.getEntity();
        if (entity1 != null){
            entity1.consumeContent();
        }
        if (cookies.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < cookies.size(); i++) {
                System.out.println("- " + cookies.get(i).toString());
                cookie = cookies.get(i);
            }
        }


    } catch (ClientProtocolException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

    try {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("loginId", username.toString()));
        nvps.add(new BasicNameValuePair("password", password.toString()));
        nvps.add(new BasicNameValuePair("_eventId_submit", "Submit"));

        HttpPost httppost = new HttpPost("url2");
        httppost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        HttpParams params = httppost.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 45000);
        HttpConnectionParams.setSoTimeout(params, 45000);

        // Perform the HTTP POST request
        HttpResponse response = client.execute(httppost);
        status = response.getStatusLine().toString();
        if (!status.contains("OK")) {
            throw new HttpException(status);
        }

        if (cookies.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < cookies.size(); i++) {
                System.out.println("- " + cookies.get(i).toString());
                cookie = cookies.get(i);
            }
        }


    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (HttpException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    try {
        List<NameValuePair> nvps2 = new ArrayList<NameValuePair>();

        nvps2.add(new BasicNameValuePair("_eventId_submit", "Submit"));

        HttpPost httppost2 = new HttpPost("url3");
        httppost2.setEntity(new UrlEncodedFormEntity(nvps2, HTTP.UTF_8));
        HttpParams params2 = httppost2.getParams();
        HttpConnectionParams.setConnectionTimeout(params2, 45000);
        HttpConnectionParams.setSoTimeout(params2, 45000);

        // Perform the HTTP POST request
        HttpResponse response2 = client.execute(httppost2);
        if (cookies.isEmpty()) {
            System.out.println("None");
        } else {
            for (int i = 0; i < cookies.size(); i++) {
                System.out.println("- " + cookies.get(i).toString());
                cookie = cookies.get(i);
                settings.setASCookie(cookie);
            }
        }

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }