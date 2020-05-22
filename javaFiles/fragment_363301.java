// use random access when reading 
raf = createObject("java", "com.lowagie.text.pdf.RandomAccessFileOrArray").init(inputPath, false, true);
pdfReader = createObject("java", "com.lowagie.text.pdf.PdfReader").init( raf, javacast("null", ""));
... 
// buffer the output
fos = createObject("java", "java.io.FileOutputStream");
outStream = createObject("java", "java.io.BufferedOutputStream").init( fos.init( outputPath ) );
pdfStamper = createObject("java", "com.lowagie.text.pdf.PdfStamper").init( pdfReader, outStream );