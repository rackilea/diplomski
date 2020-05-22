Phrase p = new Phrase("This text is added at the top of the column.");
ColumnText ct = new ColumnText(cb);
ct.setSimpleColumn(rect);
ct.setUseAscender(true);
ct.addText(p);
ct.go();