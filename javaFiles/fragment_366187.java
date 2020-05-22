String str = "aaabbbbccccca";
    char[] chars = str.toCharArray();
    char currentChar = str.length() > 0 ? chars[0] : ' ';
    char prevChar = ' ';
    int count = 1;
    StringBuilder finalString = new StringBuilder();

    if(str.length() > 0)
    for(int i = 1; i < chars.length; i++)
    {
        if(currentChar == chars[i])
        {
            count++;
        }else{
            finalString.append(currentChar + "" + count);
            prevChar = currentChar;
            currentChar = chars[i];
            count = 1;
        }
    }

    if(str.length() > 0 && prevChar != currentChar)
        finalString.append(currentChar + "" + count);

    System.out.println(finalString.toString());