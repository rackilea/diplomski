String[] header = beanReader.getHeader(true);

// only interested in first 2 columns (rest set to null)
String[] nameMapping = 
    Arrays.copyOf(new String[]{"column1","column2"}, header.length);

// processors are optional, but you can populate these if you want
CellProcessor[] processors = new CellProcessor[header.length];

// TODO: read your CSV here...