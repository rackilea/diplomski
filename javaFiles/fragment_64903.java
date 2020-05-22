String input = reader.nextLine();

char c = input.charAt(0);

if ( (c != 'M' && c != 'L') && input.length() > 1)
   // throw some error message

switch(c)
...
 case "L": //Lay:
            // parse the rest of input here
            break;