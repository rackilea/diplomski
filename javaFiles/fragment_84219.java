for (int row = 1; row < totalNoOfRows; row++) {
        numbusarray.add(sh.getCell(1, row).getContents());
    }

    for (int row = 1; row < totalNoOfRows; row++) {
        numcommutersarray.add(sh.getCell(2, row).getContents());
    }

    for (int row = 1; row < totalNoOfRows; row++) {
        numcommercialarray.add(sh.getCell(3, row).getContents());
    }