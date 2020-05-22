// Loop through each line, put the line into our line variable.
    boolean noMatches = true;
    while ((line = bf.readLine()) != null) {

        // Increment the count and find the index of the word
        linecount++;
        int indexfound = line.indexOf(searchterm);

        // If greater than -1, means we found a match
        if (indexfound > -1) {
            System.out.println("Contact was FOUND\n"
                    + "Contact " + linecount + ": " + line);
            noMatches = false;
        }
    }
    // Close the file after done searching
    bf.close();
    if ( noMatches ) {
        System.out.println( "NO MATCH FOUND.\n" );
    }