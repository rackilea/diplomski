int len = 4;
for(int i = 0; i < len; i++) {//iterates through the rows
  for(int j = 0; j < len; j++) {//iterates through the columns
    if(i == j) {
      System.out.print("-");
    }else{
      System.out.print("+");
    }
  }
  System.out.println("");//print new line after row is finished.
}