Document doc = new Document();
DocumentBuilder builder = new DocumentBuilder(doc);

builder.writeln("Content on first page");
builder.getPageSetup().setOrientation(Orientation.PORTRAIT);
builder.insertBreak(BreakType.SECTION_BREAK_NEW_PAGE);

builder.writeln("Content on second page");
builder.getPageSetup().setOrientation(Orientation.LANDSCAPE);
builder.insertBreak(BreakType.SECTION_BREAK_NEW_PAGE);

builder.writeln("Content on third page");
builder.getPageSetup().setOrientation(Orientation.PORTRAIT);

doc.save(getMyDir() + "15.10.0.docx");