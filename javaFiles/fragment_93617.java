public static void main(String[] args) {
    InputStreamReader isReader = new InputStreamReader(System.in);
    BufferedReader bufReader = new BufferedReader(isReader);
    while (true) {
      try {
        String inputStr = null;
        if ((inputStr = bufReader.readLine()) != null) {
          System.out.println(inputStr);
        } else {
          System.out.println("input is null");
          return; //end on first null
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }