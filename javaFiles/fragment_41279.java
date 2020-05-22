RtfWriter2 rtfWriter = RtfWriter2.getInstance(
    document, new FileOutputStream("out_file.rtf")
); 
document.open(); 
rtfWriter.importRtfDocument(new FileInputStream("in_file.rtf"), null); 
document.close();