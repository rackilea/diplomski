for (int i = 0; i < arr.length; i++) {
  for (int j = i+1; j < arr.length; j++) {
   System.out.println("["+arr[i] +","+arr[j]+"]");
   System.out.println("["+arr[j] +","+arr[i]+"]");
  }
}