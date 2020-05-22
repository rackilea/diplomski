...

 java.net.URL url = new java.net.URL(Url);
          ...
         else
        {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000000);
            conn.setRequestProperty("Content-Type", "text/plain; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            os.write(PostContent.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());

            String result = IOUtils.toString(in, "UTF-8");
            conn.disconnect();
            return result;
        }
    } catch (java.lang.Exception e) { return "ERROR{" + e.getMessage() + "}"; }

...