for (int row = 1; row < totalNoOfRows; row++) {
        numbusarray.add(sh.getCell(1, row).getContents());
    }

    for (int row = 1; row < totalNoOfRows; row++) {
        numcommutersarray.add(sh.getCell(2, row).getContents());

    }

    for (int row = 1; row < totalNoOfRows; row++) {
        numcommercialarray.add(sh.getCell(3, row).getContents());
    }
    // to find maximum of numbusarray
    max = 0;
    for (int row = 1; row < totalNoOfRows; row++) {
        if (!(numbusarray.get(row - 1)).isEmpty()) {
            int intNumber = Integer.parseInt(numbusarray.get(row - 1));
            if (intNumber > max) {
                max = intNumber;
                System.out.println("max: " + max);
            }
        }

    }
    System.out.println(max);
    workbook = Workbook.createWorkbook(new File("sampletestfile.xls"));
    WritableSheet wSheet = workbook.createSheet("name", 0);