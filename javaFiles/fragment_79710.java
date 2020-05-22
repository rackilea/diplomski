char[][] myArray = new char [200][200];

    for (int i=0; i<200; i++) {
        for (int j=0; j<200; j++) {
            char readFile = fileInput.readChar();
            if (readFile < '4')
                myArray [i][j] = 'x';
            else
                myArray [i][j] = 'y';
        }
    }