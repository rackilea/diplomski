int page = 1;
    for (int r = 0; r < 100 * page; r++) { //initializing row
        for (int c = 0; c < 4; c++) { //initializing column
            jTable1.setValueAt(null, r, c);
        }
    }