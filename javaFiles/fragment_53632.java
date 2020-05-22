ImagePath.setBundlePath("C:\\someDir\\sikulipatterns"); //This is to avoid supplying directory for each pattern
Screen screen = new Screen();

Pattern bigBlueArrowPattern = new Pattern("bigBlueArrow.png");
Pattern dropDownPattern = new Pattern("dropDownArrow.png");

Region bigBlueArrowPatternRegion = screen.find(bigBlueArrowPattern);
bigBlueArrowPatternRegion.grow(50).find(dropDownPattern).highlight(1);