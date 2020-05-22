public void getLetters(int cnt, int howMany, String theLetter)
{
    System.out.print("\"");
    for(int x=0; x < (howMany-cnt); x++) // you need to display spaces
        System.out.print(" ");
    for(int x=0; x < cnt; x++)
        System.out.print(theLetter);
    System.out.print("\"");
    System.out.println();
}