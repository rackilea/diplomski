URL url = new URL(theURL);
StringBuilder jsonResults = new StringBuilder();
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
InputStreamReader in = new InputStreamReader(conn.getInputStream());

            // Load the results into a StringBuilder
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }

System.out.println(jsonResults.toString());