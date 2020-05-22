PDDocument document = PDDocument.load(PDF);

LayoutTextStripper stripper = new LayoutTextStripper();
stripper.setSortByPosition(true);
stripper.fixedCharWidth = charWidth; // e.g. 5

String text = stripper.getText(document);