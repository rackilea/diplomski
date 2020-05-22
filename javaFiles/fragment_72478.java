static void deleteStudent() {
    System.out.println("Which student would you like to delete?");
    for(int i=0;i<10;i++) {
      System.out.println(i + ": " + studentNamesArray[i]);
    }
    int studentChoice = input.nextInt();
    for(int i = studentChoice+1; i<studentNamesArray.length; i++) {
      studentNamesArray[i-1] = studentNamesArray[i];
    }
    nameArrayCount = nameArrayCount -1;
  }