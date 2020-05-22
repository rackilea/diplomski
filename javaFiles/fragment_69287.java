String rev = br.readLine();

    String [] bread = rev.split(" ");
    int revCounter = 0;
    for(int z = bread.length - 1; z >= 0; z--)
    {
        String word = bread[z];
        for(int i = 0; i < word.length(); i++)
        {
            // If char at current position in 'rev' was a space then
            // just print space. Otherwise, print char from current word.
            if(rev.charAt(revCounter) == ' ')
            {
                System.out.print(' ');
                i--;
            }
            else
                System.out.print(word.charAt(i));

            revCounter++;
        }
    }