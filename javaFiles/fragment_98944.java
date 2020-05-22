//create a new array with the number of possible ascii characters
    int[] chars = new int[256];

    //loop through the length of first name
    for(int i = 0; i<fnl; i++) 
    {
        //Make lower case and save the char at index i and c
        char c = firstname.toLowerCase().charAt(i);
        //cast the saved char as a number and increment that position in the array
        chars[(int) c]++;
    }

    //repeat for last name
    for(int i = 0; i<lnl; i++) 
    {
        char d = lastname.toLowerCase().charAt(i);
        chars[(int) d]++;
    }

    //only want to print alphabetical letters a-z
    for(char e = 'a'; e <= 'z'; e++) 
    {
        //if the letter occurs 0 times, we start the loop at the next one
        if (chars[(int) e]==0)
            continue;
        else
            System.out.println("There are "+chars[(int) e]+" "+e+"'s in the String.");
    }