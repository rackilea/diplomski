ListBox assembler = (ListBox) currentInfoTable.getWidget(2, 1);
DateBox date = (DateBox) currentInfoTable.getWidget(3, 1);

while (currentAssemblyLineRow < (rowSpan + currentRow)) {
    AssemblyLine al = new AssemblyLine();
    al.setAssemblerName(assembler.getValue(assembler.getSelectedIndex()));
    al.setDate(date.getValue());
    al.setAssemblyID(Integer.parseInt(fTable.getHTML(currentRow, 0)));
    // rest of loop body goes here (current code)
}