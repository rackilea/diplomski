public static void main(String[] args) {

        int row = 7;
        int col = 7;
        int count;

        for (int i=0;i<row;i++)
        {
            count = i;
            //System.out.print("*");
            for (int c=0;c<col;c++)
            {   
                if (count == 0 || count == row-1 || c == 0)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                    count--;
                }
            }
            System.out.println("");
        }

    }