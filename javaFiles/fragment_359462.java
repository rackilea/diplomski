Scanner input = new Scanner( System.in );
int number = 0;
System.out.print("Enter number of rows: ");
number = input.nextInt();

int[][] num = new int[number][number];
int k=1, i=1, y = 0;
if (number == 1)
{
     num[0][0] = 1;
}

   while(y<number)
   {
       for(int x =0;x<number;++i,++x) 
            num[y][x] = i;


       ++y;
       if(y<number)
            for(int x = number-1;x>=0;++i,--x) 
                 num[y][x] = i;

       ++y;
   }
   for(i = 0;i<number;i++)
   {
        for(int j=0;j<number;++j)

         System.out.print(num[i][j]+"\t");
         System.out.println();   
   }