synchronized (processLock)
{
    // only one servlet thread at a time in here...
    ProcessBuilder pb = new ProcessBuilder("cscript", "C:\\Users\\Foo User\\Documents\\office2pdf.vbs", "C:\\Users\\Foo User\\Documents\\SomePPTFile.pptx"); 
    Process pr = pb.start();
    int i = pr.waitFor() ;
}