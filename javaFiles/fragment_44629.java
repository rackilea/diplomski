for(cols = 0; cols <= 4; cols++)
{
    for (rows = 0; rows <= 6; rows++)
    {
        if (rows == 0 || cols == 0) {
            System.out.print(Format.right(cols + rows, 7));
        }else {
            System.out.print(Format.right(cols * rows, 7));  
        }
    }
    System.out.println();
}