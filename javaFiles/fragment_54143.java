void camTestButton(ActionEvent event) throws IOException,InterruptedException {
    String [] array = {Cam0GO1.getText(), Cam0GO2.getText(), Cam0GO3.getText()};
    for (String st : array) {
        parseCam(st);
    }
}

public void parseCam(String st) {
      try {
          int textToInt = Integer.parseInt(st);
      } catch (NumberFormatException e) {
          try { 
              double textToDouble = Double.parseDouble(st);
          } catch (NumberFormatException e2) {}
      }
      System.out.println(st);
}