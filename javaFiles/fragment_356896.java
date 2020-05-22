Panel tablePanel = new Panel(); 
tablePanel.setHeight(400, Unit.PIXELS);
tablePanel.setWidth(240, Unit.PIXELS);

fileFormatTable = new Table(SalkkuTM.getI18N("VisibleColumnPanel.chosen.caption"));
fileFormatTable.setContainerDataSource(fileFormatListContainer);
fileFormatTable.setVisibleColumns("caption");
fileFormatTable.setColumnHeaderMode(Table.ColumnHeaderMode.HIDDEN);
fileFormatTable.setSortEnabled(false);
fileFormatTable.setSelectable(true);
fileFormatTable.setMultiSelect(true);
fileFormatTable.setDragMode(Table.TableDragMode.ROW);
fileFormatTable.setPageLength(fileFormatTable.size()); 

HorizontalLayout tableContainer = new HorizontalLayout();
tableContainer.addComponent(fileFormatTable);
tableContainer.setSizeUndefined();
tableContainer.setStyleName("innerDataTable");

tablePanel.setContent(tableContainer); 
tablePanel.setScrollable(true);