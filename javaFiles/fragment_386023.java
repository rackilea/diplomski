BufferedReader r = null;
File testfile = new File("C://test//.log");
StringBuilder b = new StringBuilder();
    try {
        r = new BufferedReader(new FileReader(testfile));
        String line = null;
        while ((line = r.readLine()) != null) {
            b.append(line);
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    finally {
       try {
          r.close()
       }
       catch (Exception ex) {
          ex.printStackTrace();
       }
    }