try {
      Runtime rt=Runtime.getRuntime();
      Process pr=rt.exec(" ...... "");
      final InputStreamReader isr=new nputStreamReader(pr.getInputStream());
      Thread th=new Thread() {
        public void run() {
          try {
            BufferedReader br=new BufferedReader(isr);
            String line=null;
            while((line=br.readLine())!=null) {
              System.out.println(line);
            }
          }
          catch (Exception ex) { }
        }
      };
      th.start();
        int exitVal=pr.waitFor();
        System.out.println("ExitValue: " + exitVal);
   }
    catch (Exception ex) { ex.printStackTrace(); }