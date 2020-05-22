public static void main(String args[])
    {
        try {
            CellGrid grid = new CellGrid("ascii.txt");
            System.out.println(CellGrid.printDIV(grid.findBoxes(null)));
            //System.out.println(grid.printGrid());
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }