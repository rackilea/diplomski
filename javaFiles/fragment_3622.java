for (Row row : sheet) {
    for (Cell cell : row) {
        if (cell != null) {
            obj.add(row.getCell(x).toString());
        }
    }
}
System.out.println(obj.toString());