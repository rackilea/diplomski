try
            {
                HttpClient client=new DefaultHttpClient();
                HttpPost request=new HttpPost("your url");

                BasicNameValuePair email=new BasicNameValuePair("username", "your username");
                BasicNameValuePair password=new BasicNameValuePair("password", "your password");

                List<NameValuePair> list=new ArrayList<NameValuePair>();
                list.add(username);
                list.add(password);

                UrlEncodedFormEntity urlentity=new UrlEncodedFormEntity(list);
                request.setEntity(urlentity);

                HttpResponse response=client.execute(request);

                HttpEntity entity=response.getEntity();
                String tmp=EntityUtils.toString(entity);
                return tmp;
            }
            catch(Exception e)
            {
                return e.toString();
            }