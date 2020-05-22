if (model.getValueAt(i, j) != null) {
   val = model.getValueAt(i, j).toString();
   } else {
  val = "NULL"; //you can change value to any thing you want to represent null values
          }
   row.createCell(j).setCellValue(val);