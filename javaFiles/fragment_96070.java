// Initialize array
String [][] array = {{"00", "01", "02", "03", "04", "05", "06", "07"},
                     {"10", "11", "12", "13", "14", "15", "16", "17"},
                     {"20", "21", "22", "23", "24", "25", "26", "27"},
                     {"30", "31", "32", "33", "34", "35", "36", "37"},
                     {"40", "41", "42", "43", "44", "45", "46", "47"},
                     {"50", "51", "52", "53", "54", "55", "56", "57"},
                     {"60", "61", "62", "63", "64", "65", "66", "67"},
                     {"70", "71", "72", "73", "74", "75", "76", "77"},
                     };

// Simply output the original array so we can visually compare later
for (int i = 0; i < 8; ++i) {
    for (int j = 0; j < 8; ++j) {
        System.out.print(" " + array[i][j]);
    }
    System.out.println("");
}

// Create a new array that is twice the size as the original array
String[][] scaledArray = new String[16][16];

// Scale the original array into the new array
for (int i = 0; i < 8; ++i) {
    for (int j = 0; j < 8; ++j) {
        scaledArray[(i*2)][(j*2)] = array[i][j];
        scaledArray[(i*2) + 1][(j*2)] = array[i][j];
        scaledArray[(i*2)][(j*2) + 1] = array[i][j];
        scaledArray[(i*2) + 1][(j*2) + 1] = array[i][j];
    }
}

// Output the scaled array to see the result
System.out.println("\nSCALED: ");
for (int i = 0; i < 16; ++i) {
    for (int j = 0; j < 16; ++j) {
        System.out.print(" " + scaledArray[i][j]);
    }
    System.out.println("");
}