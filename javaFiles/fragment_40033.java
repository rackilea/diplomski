int finalRowSize = 4; //Set here the chunks size
String[] itemcell = {"renu","1252","ed","dev","kalam","8562","ed","dev"};
String[][] result =  monoToBidi(itemcell,itemcell.length / finalRowSize, finalRowSize); 

public static String[][] monoToBidi(final String[] array, final int rows, final int cols){        
        String[][] bidi = new String[rows][cols];
        for ( int i = 0; i < rows; i++ )
            System.arraycopy(array, (i*cols), bidi[i], 0, cols);        
        return bidi;
}