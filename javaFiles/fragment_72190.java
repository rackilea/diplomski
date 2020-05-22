System.out.print("Please enter a sentence: ");
    String originalsent = scan.nextLine();
    sentlength=originalsent.length();

    System.out.println("The sentence is "+ sentlength +" characters long");   
    System.out.println("Please enter a number less than the length of the sentence: ");
    lowerinput = scan.nextInt();
    System.out.println("The character at index " + lowerinput + " is " + originalsent.charAt(lowerinput));
    System.out.println("Please enter a character: ");
    enterletter = scan.next();
    System.out.println("The first index " + enterletter + " shows up is at " + originalsent.indexOf(enterletter));