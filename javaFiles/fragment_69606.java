if (tblData.getValueAt(row, 1).equals(bib)) {
   // you must call setFont(...) for a font to change
   cellComponent.setFont(cellComponent.getFont().deriveFont(Font.BOLD));
} else {  
   // don't forget to set the font back if condition not true
   cellComponent.setFont(cellComponent.getFont().deriveFont(Font.PLAIN));
}

// changing foreground color:
if (tblData.getValueAt(row, 3).equals("M")) {
   cellComponent.setForeGround(MEN_COLOR); // a constant
} else {  
   cellComponent.setForeGround(myTable.getForeground());
}