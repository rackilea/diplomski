FixedWidthParserSettings settings = new FixedWidthParserSettings();
settings.getFormat().setLineSeparator("\n");
settings.setRecordEndsOnNewline(false);
settings.setHeaderExtractionEnabled(false); // This one is important as your input has no headers.

FixedWidthRoutines routines = new FixedWidthRoutines(settings);
for(Bean bean : routines.parseAll(Bean.class, new StringReader(input))){
    System.out.println(bean);
}