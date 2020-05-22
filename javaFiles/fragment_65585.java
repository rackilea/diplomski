java.io.File test2 = new java.io.File("C:/c.txt");
           Scanner input = new Scanner(test2);
           String arr[][]=new String[5][5];
           int i=0,j=0;
           while(input.hasNext())
           {
               String val=input.nextLine();
               j=0;
               if(val.contains(" "))
               {
                   String str[]=val.split(" ");
                   int cn=str.length;
                   while(cn>0)
                   {
                       arr[i][j]=str[j];
                       cn--;
                       j++;
                   }
               }
               else
                   arr[i][j]=val;
               i++;
           }

            for(int i1=0;i1<5;i1++)
            {
                 for(int j1=0;j1<5;j1++)
                     if(arr[i1][j1] != null)
                     System.out.print(arr[i1][j1]); 
                 System.out.println();
            }