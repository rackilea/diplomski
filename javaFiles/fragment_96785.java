public static void main(String[] args) throws IOException
{
    File dir = new File("....");
    File[] files = dir.listFiles(new FilenameFilter()
    {
        // use anonymous inner class 
        @Override
        public boolean accept(File dir, String name)
        {
            return name.toLowerCase().endsWith(".pdf");
        }
    });
    // null check omitted!
    for (File file : files)
    {
        int len = file.getAbsolutePath().length();
        String txtFilename = file.getAbsolutePath().substring(0, len - 4) + ".txt";
        // check whether txt file exists omitted
        try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(txtFilename), Charsets.UTF_8);
             PDDocument document = PDDocument.load(file))
        {
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.writeText(document, out);
        }
    }
    // exception catch omitted. Add code here to avoid your whole job
    // dying if only one file is broken
}