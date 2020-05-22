String data = "acgtcgcgagagagggggcccataatggg";
    int    longestPos = 0;
    int    longestLen = 0;
    int p=-1;
    for (int i=0; i<data.length(); i++)
    {
        char c = data.charAt(i);
        if (c == 'c' || c == 'g')  // Is this the droid you're looking for?
        {
            if (p==-1)  // Are we not yet in an interesting string?
                p = i;  // If so, save the position of this start of substring.
        }
        else  // Not a c or g
        {
            if (p != -1 && i-p > longestLen)  // Are we in an interesting string longer than the previous longest?
            {
                longestPos = p;     // Save the starting position
                longestLen = i-p;   // Save the length
            }
            p = -1;   // We're no longer inside an interesting string
        }
    }

    // Handle the case where the last substring was 'interesting'
    if (p != -1 && i-p > longestLen)
    {
        longestPos = p;     // Save the starting position
        longestLen = i-p;   // Save the length
    }

    System.out.printf("Longest string is at position %d for length %d", longestPos, longestLen);