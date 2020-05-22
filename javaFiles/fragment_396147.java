for(int j=0; j < length; j++)
{
      for (char d = 0; d < 127; d++) 
      {
        if(PasswordGenerator.matchCharAt(d, j)) 
        {
            password.append(d);
            System.out.println("Hey! Char at " + index + " is " + d);

            // No sense in incrementing d and going through all of them
            // You found it already, break this loop
            break;
        }
    }
}