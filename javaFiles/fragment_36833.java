Row row = CursorBuilder.findRow(table, Collections.singletonMap("Active", true));
if (row != null) {
    System.out.println("Found row : " + row);
}
else {
    System.out.println("Could not find row");
}