public void increaseSize() {
      String[] temp = new String[output.length + 1000];
      for (int i = 0; i < output.length; i++) {
          temp[i] = output[i];
          output = temp; // <-- here
      }    
}