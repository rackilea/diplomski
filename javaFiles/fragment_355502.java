try {
        s = new Scanner(new BufferedReader(new FileReader("C:/Users/Daniel/Desktop/Cleaned.txt")));
        s.useDelimiter("\\*");
        String total = (s.next());
        Pattern p = Pattern.compile("\\n[\\n]+");

        String[] parts = p.split(total);

        boolean searchArrayResult = false;
        java.io.File targetFile =new java.io.File("op.txt");
        java.io.FileWriter filew=new java.io.FileWriter(targetFile);
        java.io.PrintWriter print=new java.io.PrintWriter(filew,true);
         for (String str : parts) {
            searchArrayResult = str.contains("1ST COAT   BASIS WT");
            if (searchArrayResult) {
                //System.out.println(str);
                print.println(str);
              }
           }
        while (s.hasNext()) {
        }
     } catch (Exception ex) { }