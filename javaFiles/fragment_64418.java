Scanner sc = new Scanner(System.in);
System.out.println("Enter string: ");
char s[] = sc.nextLine().toCharArray();
HashMap<Character, Integer> charsFound = new HashMap<>();
int count = 1;
char c = s[0];
for(int i = 1;i < s.length; i++)
{
    //check the edge case where the last of the array is consecutive chars
    if(c==s[i] && count >= 1 && s.length - 1 == i)
    {
        if(!charsFound.containsKey(c))
            charsFound.put(c, ++count);
        else if(charsFound.get(c) < ++count)
            charsFound.put(c, count);
    }
    //increment the count if the character is the same one
    else if(c==s[i])
    {
        count++;
    }
    //consecutive chain is broken, reset the count and our current character
    else
    {
        if(count > 1)
        {
            if(!charsFound.containsKey(c))
                charsFound.put(c, count);
            else if(charsFound.get(c) < count)
                charsFound.put(c, count);
        }
        //reset your variables for a new character
        c = s[i];
        count = 1;
    }
}

for (char knownCharacters : charsFound.keySet())
    if (charsFound.get(knownCharacters) > 1)
        System.out.println(knownCharacters + "-" + charsFound.get(knownCharacters));