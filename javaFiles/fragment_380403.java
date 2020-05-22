JButton[][] button = new JButton[10][10];
String str = "fireshot";

for(int i=0;i<10;i++)
{
     for(int j=0;j<10;j++)
     {
        button[i][j] = new JButton(str+i+j);
     }

}