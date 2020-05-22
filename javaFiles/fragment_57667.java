public void increaseSize() {
      String[] temp = new String[output.length + 1000];
      for (int i = 0; i < output.length; i++) {
          temp[i] = output[i];
      }
      // Once the loop is finished, and the whole contents have been copied, use the `temp` array as the new `output`.
      output = temp;
}