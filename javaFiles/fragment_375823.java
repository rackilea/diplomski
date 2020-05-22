public static void main(String[] args) {

        int row = 7;
        int col = 7;
        int count;
        String strNewLine = "*" + System.lineSeparator();
        String str = "*";
        String strToPrint;

        for (int i=0;i<row;i++)
        {
            count = i;
            for (int c=0;c<col;c++)
            {   
                if (count == 0 || count == row-1 || c == 0)
                {
                    if (c == row-1)
                    {
                        strToPrint = strNewLine;
                    }
                    else
                    {
                        strToPrint = str;
                    }

                    System.out.print(strToPrint);
                }
                else
                {
                    System.out.print(" ");
                    count--;
                }
            }
        }

    }