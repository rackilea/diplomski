public static void moveChars(int numberOfMovesForChar)
{
    Scanner in = new Scanner(System.in);

    // StringBuilder builder = new StringBuilder();

    System.out.println("Insert any line of text: ");
    String line = in.nextLine();

    // move all chars number of position given from user input and check 
    //if it is positive 


    PrintWriter out;
    try
    {
        File file = new File("filePath");
        if (!(file.exists()))
        {
            file.createNewFile();
        }

        out = new PrintWriter(new FileOutputStream(file));

        out.println(move(line, numberOfMovesForChar));
        out.flush();
        out.close();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
}

public static String move(String orig, int moves) {
    StringBuilder builder = new StringBuilder();
    if (moves == 0) {               // take a copy
        builder.append(orig);
    }
    else if (moves > 0) {           // add initial spaces
        for (int i=0; i< moves; i++) {
            builder.append(' ');
        }
        builder.append(orig);
    }
    else {
        builder.append(orig.substring(-moves));    // copy a substring
    }
    return builder.toString();
}