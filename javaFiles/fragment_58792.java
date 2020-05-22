.....
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            products = new Products(); // re-instantiation.
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
       .....