for (int i = 0; i < 6; i++) 
 {
        for (int j = 0; j < 3; j++) 
        {
            if (i > 0 && i < getLength() -1 && j > 0 && j < getWidth() -1) 
            {
                System.out.print("  ");
            }
            else 
            {
                System.out.print("o ");
            }
        }
        System.out.println();
}