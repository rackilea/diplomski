try {
    int returnCode = client.executeMethod(method);
    if(returnCode == 405 ) {
        System.out.println("The XXX method is not implemented by this URI");
    } else {
        Header[] header = method.getResponseHeaders();
        for(int i = 0; i < header.length; i++) {
            System.out.println(header[i].getName() + ": " + header[i].getValue());
        }
        br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
        byte[] buf = new byte[1024];
        String readLine;
        while (((readLine = br.readLine()) != null)) {
            System.out.println(readLine);
        }
    }
  } catch(Exception e) {
        e.printStackTrace();
   } finally {
        System.out.println("close method");
        method.releaseConnection();
        try {
        br.close();
        } 
        catch(IOException ioe) {}
 }