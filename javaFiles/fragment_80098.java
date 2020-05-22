// Blank workbook
    XSSFWorkbook workbook = new XSSFWorkbook();

    final Sheet sheet = workbook.createSheet("Export values");

    // Get the Entity
    final Simfoot simEntity = simService.findById(simId).get();

    Row row = sheet.createRow(0);
    row.createCell(1).setCellValue("Consult our values");

    // and after this I want to convert my Simfoot object to a column in the third column ( so creteCell(2) ..... ).
    Arrays.stream(simEntity.getClass().getDeclaredMethods())
            .filter(m -> m.getName().startsWith("get") && m.getParameterTypes().length == 0 && !void.class.equals(m.getReturnType()))
            .forEach(m -> {
                    try {
                            Object value = m.invoke(simEntity, null);
                            Row r = sheet.createRow(sheet.getLastRowNum()+1);
                            r.createCell(2).setCellValue(value == null ? "" : value.toString());
                    }
                    catch (Exception ex) {
                            // Manage Exception....
                    }
            });