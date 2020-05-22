int responseCodeFromServer = -1;
    try {
         responseCodeFromServer=conn.getResponseCode();
    } catch (Exception e){
         e.printStackTrace();
    }

    if (responseCodeFromServer == HttpsURLConnection.HTTP_OK){
         BufferedReader reader = null;
         reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         StringBuilder sb = new StringBuilder();
        String line = null;

       // Read Server Response
       while ((line = reader.readLine()) != null) {
          // Append server response in string
          sb.append(line + "\n");
       }

       String text = "";
       text = sb.toString();
    }