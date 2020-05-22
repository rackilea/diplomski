String[] sweetFlevors = { "Caramel", "Cinnamon", "Wetermelon", "Backed Beans" };

String[] savoryFlavors = { "Sea Salt", "Potato Chip", "Carrot", "Barbque" };

int[] numberRows = { 1, 2, 3, 4 };
int[] numberCol = { 1, 2 };

System.out.println("       " + numberCol[0] + "         " + numberCol[1]);
for (int col = 0; col < numberCol.length; col++) {
    for (String sweet: sweetFlevors) {
        for (String savory: savoryFlavors) {
            for (int row = 0; row < numberRows.length; row++) {
                System.out.print(numberRows[row] + ". ");

                System.out.println(sweet + " and " + savory);
            }
        }
    }
}