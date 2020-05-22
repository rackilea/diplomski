do {
    System.out.print("Which animal are you looking to check into the kennel?: " + "\n");
    System.out.println("Dog");
    System.out.println("Cat");  
    tempFileName = scan.next();
    if(tempFileName.equals("dog") || tempFileName.equals("cat"))
    { 
       filename = tempFileName.equals("dog") ? dogsFile : catsFile;
       fileNotCorrect = true;
    }else{
      System.out.println("That is not a valid filename, please enter either 'dog' or 'cat' in lowercase.");
    }
}
    while(!fileNotCorrect);