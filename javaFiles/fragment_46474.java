public static File convertPSToPdf(String psFile){
    Ghostscript gs = Ghostscript.getInstance();
    String[] gsArgs = new String[8];
    gsArgs[1] = "-sDEVICE=pdfwrite";
    gsArgs[2] = "-dCompatibilityLevel=1.4";
    gsArgs[3] = "-dNOPAUSE";
    gsArgs[4] = "-dBATCH";
    gsArgs[5] = "-r150";
    gsArgs[6] = "-sOutputFile=C:/Users/DOS20/Desktop/rendition.pdf";
    gsArgs[7] = psFile;
    try {
        gs.initialize(gsArgs);
        gs.exit();
        return new File("C:/Users/DOS20/Desktop/rendition.pdf");
    } catch (GhostscriptException e) {
        System.out.println(e.toString());
    }
    return null;
}