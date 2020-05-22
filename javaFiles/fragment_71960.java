int responses[] = new int[4];
    responses[0] = 1;
    responses[1] = 2;
    responses[2] = 4;
    responses[3] = 4;

    int freq[] = new int[5];

    for(int answer = 1; answer < 4; answer++)
    {
        int x = responses[answer];
        freq[x] = freq[x] + 1;
    }

    for (int rating = 1; rating < 5; rating++)
    {  
         //Print 6 spaces and then the rating variable
         //Print 10 spaces then the integer at freq[rating]

         System.out.printf("%6d%10d\n", rating, freq[rating]);
    }