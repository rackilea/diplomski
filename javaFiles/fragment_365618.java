URL u = new URL("https://www.whitehouse.gov/");
    InputStream ins = u.openStream();
    InputStreamReader isr = new InputStreamReader(ins);
    BufferedReader websiteText = new BufferedReader(isr);
    String inputLine;
    while ((inputLine = websiteText.readLine()) != null){
        System.out.println(inputLine);
   }

  websiteText.close();