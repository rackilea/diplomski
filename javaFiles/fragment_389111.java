ListGridField rowNumberField = new ListGridField();

// Either
//-------------------------------------------------------
  rowNumberField.setWidth(15); //Whatever width you want
//-------------------------------------------------------
// Or
//-------------------------------------------------------
  rowNumberField.setAutoFitWidth(true);
//-------------------------------------------------------

ListGrid listGrid = new ListGrid();

listGrid.setRowNumberFieldProperties(rowNumberField);