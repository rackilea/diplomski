int[][] mat = new int[Integer.valueOf(dimensions[1])]
                         [Integer.valueOf(dimensions[0])];

    int colA = mat[0].length;
    int rowA = 0;
    int colB = colA;
    int rowB = 0;
    for (int i = 0; i < mat.length; i++) {
        String currLine = lines.get(i+1);
        int j = 0;
        for (char c : currLine.toCharArray()) {
            mat[i][j] = c == '*' ? -1 : 0;
            if (c == 'B') {
                if (colA > j) return 0; // B unreachable from A
                rowB = i;
                colB = j;
            } else if (c == 'A') {
                if (colB < j) return 0; // B unreachable from A
                rowA = i;
                colA = j;
            }
            j++;
        }
    }