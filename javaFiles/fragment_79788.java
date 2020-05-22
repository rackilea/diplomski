System.out.println("What block are you gathering? (use minecraft block ids)");
while(!input.hasNextInt()){
    input.nextLine();// consume invalid values until end of line, 
                     // use next() if you want to consume them one by one.
    System.out.println("That is not integer. Please try again");
}
//here we are sure that next element will be int, so lets read it
block = input.nextInt();