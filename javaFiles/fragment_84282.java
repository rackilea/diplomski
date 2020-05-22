char[][] charMap = new char[100][100];
long startTime = System.currentTimeMillis();
for(int i = 0; i < charMap.length; i++)
{
    for(int j = 0; j < charMap[0].length; j++)
    {
        System.out.print(charMap[i][j]);
        System.out.print(" ");
    }
    System.out.println("");
}
System.out.println((System.currentTimeMillis() - startTime) + " ms");