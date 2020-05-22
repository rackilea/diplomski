public static void main(String[] args) {
    BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
    String inputStr = null;
    try {
      while ((inputStr = bufReader.readLine()) != null) {
        System.out.println(inputStr);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("end of file");
  }