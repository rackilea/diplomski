try {
                URL url = null;
                try {
                    url = new URL("https://www.yobit.net/api/3/info");
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
                HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
                try {
                    con.setRequestMethod("GET");
                } catch (ProtocolException e1) {
                    e1.printStackTrace();
                }
                con.setRequestProperty("user-Agent", "Mozilla/5.0 (compatible; JAVA AWT)");
                con.setRequestProperty("Accept-Language","en-US,en;q=0.5");

                con.setDoOutput(true);
                con.setUseCaches(false);
                con.connect();

                try {
                    System.out.println(con.getResponseCode());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }