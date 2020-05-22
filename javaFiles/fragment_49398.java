public static void main(String[] args) throws IOException {
      URL u = null;
      try {
          u = new URL(args[0]);
      } catch (MalformedURLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }

      BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
      String line = null;
      while((line = in.readLine()) != null){
          System.out.print(line);
      }
  }