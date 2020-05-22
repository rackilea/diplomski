int check [][]= new int [100][100];

public void actionPerformed(ActionEvent e)
{           
    if(e.getActionCommand().contains("button"))
    {
        String str = e.getActionCommand().replaceAll("button", "");
        System.out.println(str);
        String[] v = str.split("_");
        int i = Integer.parseInt(v[0]);
        int j = Integer.parseInt(v[1]);            
        intArray[i][j]++;
        if(check[i][j]!=1){
            buttons[i][j].setBackground(Color.BLUE);
            check[i][j]=1;
        }
        else{
            buttons[i][j].setBackground(null);
            check[i][j]=0;
        }
    //buttons[i][j].setBackground(null);
    System.out.println(e.getActionCommand() +"  " +i +"  " +j);
    // System.out.println();
    score2();
}