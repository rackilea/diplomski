new Thread() {
        public void run() {
            URL url = null;
            BufferedReader in = null;
            try {
                url = new URL("your url");

                in = new BufferedReader(
                        new InputStreamReader(
                                url.openStream(),"UTF-8"));//in most cases there is utf 8

                String inputLine;
                StringBuilder builder = new StringBuilder();
                while ((inputLine = in.readLine()) != null)
                    builder.append(inputLine);
                String urlContent = builder.toString();
                // process your received data somehow
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }.start();