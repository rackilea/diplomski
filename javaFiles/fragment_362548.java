public static void displaymap(int maparray[][])
  {
    String mapicons[][] = new String [22][32];
    int col=1;
    int row=1;
    int row2=0;
    int col2=0;
    double sum[]= new double [704];
    for(int i=0;i<704;i++)
    {
      if(col ==33)
      {
        col = 1;
        row++;
        if(row==24)
        {
          row=0;
          col=0;
          break;
        }
      }
      sum[i]=(double)(maparray[row][col]+maparray[row-1][col]+maparray[row+1][col]+maparray[row][col-1]+maparray[row][col+1])/6;
      col++;
      System.out.printf("%.2f\n",sum[i]);
      if(sum[i]>=9)
        {
          mapicons[row2][col2]=" #";
        }
      else if(sum[i]>=8)
        {
          mapicons[row2][col2]=" *";
        }
      else if(sum[i]>=7)
        {
          mapicons[row2][col2]=" +";
        }
      else if(sum[i]>=6)
        {
          mapicons[row2][col2]=" .";
        }
      else
        {
          mapicons[row2][col2]="  ";
        }
      col2++;
      if(col2 ==32)
        {
          col2 = 0;
          row2++;
         }
    }
    for(row=0;row<22;row++)
      {
        for(col=0;col<32;col++)
          System.out.printf("%s",mapicons[row][col]);
        System.out.println();
      }
  }