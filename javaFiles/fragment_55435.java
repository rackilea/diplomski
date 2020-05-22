file = new File(filePath);
parser = new PDFParser(new RandomAccessFile(file,"r"));
parser.parse();
cosDoc = parser.getDocument();
pdfStripper = new PDFTextStripper();
pdDoc = new PDDocument(cosDoc);