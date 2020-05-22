public String[][] populateWithShips(String[][] grid){
    int shipCount = 6;
    for (int shipIndex = 0; shipIndex < shipCount; shipIndex++) {
        boolean shipExists = false;
        while(shipExists != true){//Another way you could do this is (!shipExists)
            System.out.println("Please enter the column number for ship number " + shipIndex + :");
            int column = Integer.parseInt(this.keyboard.next());//This will take the input String and parse it to a Integer object
            System.out.println("Please enter the row number for ship number " + shipIndex + :");
            int row = Integer.parseInt(this.keyboard.next());
            //Note I haven't verified that this inputs are correct, just assuming they user enter good inputs

            if(grid[column][row] != null){
                System.out.println("Sorry, coordinates already used. Try again.\n");
            }
            else{
                grid[column][row] = " s ";
                shipExists = true;
            }
        }   
    }
    return grid;
}