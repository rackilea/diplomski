int i = 0;

try{
    for (; i < word.length(); i++)
        counts[word.charAt(i)-'A']++;
}
catch (ArrayIndexOutOfBoundsException Exception)
{
    System.out.println("Not a Letter: " + word.charAt(i));

}