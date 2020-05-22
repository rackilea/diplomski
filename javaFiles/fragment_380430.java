for (List<String> row : results.getRows()) {
  for (String column : row) {
    pw.print(row + ",");
  }
  pw.println();
}