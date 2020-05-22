try {
                URL url = new URL("http://youserver.com");
                URLConnection urlConnection = url.openConnection();
                urlConnection.setConnectTimeout(2000); //Connection timeout
                urlConnection.connect();
                System.out.println("Server is up and running");
            } catch (Exception e) {
                System.out.println("Server is not yet up");
            }