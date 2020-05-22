int[][] thisGen = new int[40][40]; 

public void actionPerformed(ActionEvent e){
       Graphics g = getGraphics();
       for(int i = 0; i<40; i++)
       {
           for(int j = 0; j<40; j++)
           {
               if(g.getColor() == Color.red)
               {
                   thisGen[i][j] = 1;
               }
               else
               {
                   thisGen[i][j] = 0;
               }
           }
       }

       //////1. I don't feel there is any link between these two loops

        for(int x = 0; x<thisGen.length; x++)
        {
           for(int y = 0; y<thisGen[x].length; y++)     //2. replaced o by x if you've Jagged array
           {
               System.out.println(thisGen[x][y] +" ");
           }
           System.out.println();
       }
}