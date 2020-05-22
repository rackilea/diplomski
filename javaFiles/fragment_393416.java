//read file a.txt into the array lines
    String lines[] = raedFileIntoArray("a.txt");

    int numberOfLines = lines.length;
    int numberOfCols = 4;

    int maxNumOfLines = numberOfLines / numberOfCols;

    for (int row = 0; row < maxNumOfLines; ++row) {
        for (int col = 0; col < numberOfCols; ++col) {
            System.out.print(lines[maxNumOfLines * col + row]);
            if (col + 1 < numberOfCols)
                  System.out.print("\t");
        }
        System.out.print("\n");
    }