String wsURL = "https://hostservername:postnumber";
                String wsUserName = "someUserName";
                String wsPassword = "somePassword";

                try{
                    String authString = wsUserName+":"+wsPassword;
                    byte[] byteAuthStr = authString.getBytes();
                    String authBase64Str = Base64.encode(byteAuthStr);
                    System.out.println(authBase64Str);
                URL url = new URL(wsURL);
                URLConnection  conn =  url.openConnection();
                HttpURLConnection connection = (HttpURLConnection)conn;
                connection.setDoOutput(true); 
                /*connection.setRequestMethod("GET");
                 connection.setRequestMethod("POST");*/   

connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("Authorization", "Basic "+authBase64Str);
                connection.connect();
               System.out.println( connection.getResponseCode());
             boolean connected = false;
           switch (connection.getResponseCode()) {
           case HttpURLConnection.HTTP_OK:
               System.out.println(url + " **OK**");
               connected = true;
               break; // fine, go on
           case HttpURLConnection.HTTP_GATEWAY_TIMEOUT:
               System.out.println(url + " **gateway timeout**");
               break;// retry
           case HttpURLConnection.HTTP_UNAVAILABLE:
               System.out.println(url + "**unavailable**");
               break;// retry, server is unstable
           default:
               System.out.println(url + " **unknown response code**.");
               break ; // abort
      }
    }catch(Exception ex){
                System.err.println("Error creating HTTP connection");
                System.out.println(ex.getMessage());
            }
        }