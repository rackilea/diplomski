String s;
for( int i = 0; i < 10; i++)
{
    s = "";
    for( int j = 0; j <= i; j++)
        s+= "X";
    for( int j = i+1; j < 10; j++)
        s+= "O";
    System.out.println(s);
}