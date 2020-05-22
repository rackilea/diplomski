ColumnText.showTextAligned(cbb, Element.ALIGN_LEFT, new Phrase(pageNoString,FontFactory.getFont(FontFactory.COURIER,12,new BaseColor(0xFF, 0x00, 0x00))), 50, 95, 0);
newtable.addCell(imageCell);
newtable.addCell(textCell);
column.addElement(newtable);
column.setSimpleColumn(30, 130, 570, 45,5f, Element.ALIGN_RIGHT | Element.ALIGN_BOTTOM |Element.ALIGN_JUSTIFIED_ALL);
column.go();