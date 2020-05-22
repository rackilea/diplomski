String str = "57363 Joy Ryder D D C P H H C D";

    Scanner tokens = new Scanner(str);

    String studentID = tokens.next();

    String name = tokens.next();

    String surname = tokens.next();

    String letters = "";

    while(tokens.hasNext())
    {
        letters = letters + tokens.next() + " ";
    }

    System.out.println("ID = " + studentID +
                       "\nNAME = " + name +
                       "\nSURNAME = " + surname + 
                       "\nLETTERS = "+ letters);