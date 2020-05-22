XWPFParagraph p;
...
// get or create your paragraph
....
CTP ctP = p.getCTP();
CTSimpleField toc = ctP.addNewFldSimple();
toc.setInstr("TOC \\h");
toc.setDirty(STOnOff.TRUE);