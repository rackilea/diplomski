public int letterScore(String word)
{
    int lettervalue = 0;
    char wordchar;
    for(int i=0; i < word.length();i++)//what was this ; here?
    {
        wordchar = word.charAt(i);

        switch(wordchar)
        {
            case 'A': case 'E': case 'I': case 'L': case 'N': case 'O': case 'R':      case 'S': case 'T': case 'U':
            lettervalue+= 1;
            break;
            case 'D': case 'G':
            lettervalue+=2;
            break;
            case 'B': case 'C': case 'M': case 'P':
            lettervalue+=3;
            break;
            case 'F': case 'H': case 'Y': case 'V': case 'W':
            lettervalue+=4;
            break;
            case 'K':
            lettervalue+=5;
            break;
            case 'J': case 'X':
            lettervalue+=8;
            break;
            case 'Q': case 'Z':
            lettervalue+=10;
            break;        
       }



    }
    return lettervalue;
}