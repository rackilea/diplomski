URL url = new URL("Link to dropbox");
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setDoOutput(false);
                con.setReadTimeout(20000);
                con.setRequestProperty("Connection", "keep-alive");

                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:16.0) Gecko/20100101 Firefox/16.0");
                ((HttpURLConnection) con).setRequestMethod("GET");
                //System.out.println(con.getContentLength()) ;
                con.setConnectTimeout(5000);
                BufferedInputStream in = new BufferedInputStream(con.getInputStream());
                int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    System.out.println(responseCode);
                }
                StringBuffer buffer = new StringBuffer();
                int chars_read;
                //int total = 0;
                while ((chars_read = in.read()) != -1) 
                {
                    char g = (char) chars_read;
                    buffer.append(g);
                }
                final String page = buffer.toString();