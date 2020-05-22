FileInputStream stream = new FileInputStream(logfile);
    BufferedReader br = new BufferedReader(new InputStreamReader(stream));

    String line;

    while ((line = br.readLine()) != null)   {
      System.out.println (line);
    }