for (i = 0; i < ROWS; i++)
        {

            for (j = 0; j < COL; j++)
            {
                if(j==0) //if it is first column value
                {
                System.out.print(cellPhoneNumbers[i][j]+" "); //this prints Country name and leaves a space as you need chillie (space) ****
                }
                if(j==1) //this checks that if value is second one as that is integer
                {
                    for(int x=0;x<Integer.parseInt(cellPhoneNumbers[i][j]);x++)  //if a int value so I have written a loop , which will print that many *
                    {

                        System.out.print("*");
                    }
                }

            }
            System.out.println(""); //So as if first row is done then it moves to next line to print

        }