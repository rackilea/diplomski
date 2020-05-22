private static int[] parseIntLine(String line){
  String[] arr = line.trim().split(' '); //Split on the space character
  int[] intArr = new int[arr.length];
  for(int i = 0; i < arr.length; i++){
    intArr[i] = Integer.parseInt(arr[i]);
  }
  return intArr;
}