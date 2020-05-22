private void readAndValidateContents(){
    if(externalLOB.size() == 2){
        try {       
            PdfReader reader = new PdfReader(externalLOB.get(0).getAbsolutePath());     
            PdfReaderContentParser parser = new PdfReaderContentParser(reader);
            //Trying to Extract Images to a tmp folder
            ImageRenderListener listener = new ImageRenderListener(OneMethod.getElementosPath() + "/db/tmp/Img%s.%s");

            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                parser.processContent(i, listener);
            }

            //Retrieving String values from images extracted to tmp folder
            ArrayList<String> ary = OneMethod.decodeBarcodes();

            //Extracting String values from PDF Page using iText API
            String[] contents = (PdfTextExtractor.getTextFromPage(reader, 1)).split("\n");
            externalKey.clear();

            System.out.println("\n\n");

            short line = 0;
            for(String str : contents){
                System.out.println(line++ + str);
            }

            String tempVal = ary.get(0);
            String[] split = tempVal.split("\n");
            tempVal = split[0];

            tempVal = tempVal.substring(0, tempVal.indexOf("."));
            System.out.println("\n\n" + tempVal + "\n\n");

            if(contents[4].equals(tempVal)){ //comparing qr bar code file name with pdf text file name  
                System.out.println("Something XYZ....Here...Done...")
            }else{
                System.err.println("Possibilities for File Interruption, File different of requested...");
            }           
        } catch (StringIndexOutOfBoundsException spiobe){
            System.err.println("File different of requested...");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally{
            OneMethod.clearDirectory(OneMethod.getElementosPath() + "/db/tmp/");
        }
    }
}

class OneMethod {
    static synchronized ArrayList<String> decodeBarcodes(){
        ArrayList<String> ary = new ArrayList<String>();
        short suffix = 1;
        File imageFile = null;

        outer:
        while(true){
            if(++suffix > 5) //Starting to read the Img with Suffix 2 i.e. Img2.jpg
                break outer;
            inner:
            while(true){
                try{
                    InputStream barCodeInputStream;
                    imageFile = new File(OneMethod.getElementosPath() 
                        + "/db/tmp/Img" + suffix + (suffix != 2 ? ".png" : ".jpg"));
                    if(imageFile.exists() && imageFile.isFile()){
                        barCodeInputStream = new FileInputStream(imageFile.getAbsolutePath());
                        BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

                        //Using zxing-core-3.2.0 with collaborating the old 1.3 version com.google.zxing.client.j2se package inside.
                        //So doing above action you will get the BufferedImageLuminanceSource class which is now not available in new versions.

                        LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
                        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                        Reader reader = new MultiFormatReader();
                        Result result = reader.decode(bitmap);

                        System.out.println(suffix + " value is : " + result.getText());

                        ary.add(result.getText());
                    }else{
                        System.out.println(imageFile.getAbsolutePath() + " path is not available...");
                    }
                    break inner;
                } catch(FileNotFoundException | NullPointerException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (NotFoundException | ChecksumException | FormatException ex) {
                    ex.printStackTrace();
                }
            }
        }       
        return ary;
    }

    static synchronized void clearDirectory(final String dirPath){
        new Thread(new Runnable(){
            public void run(){
                try{
                    File directory = new File(dirPath);
                    if(directory.isDirectory() == true)
                        try {
                            File[] files = directory.listFiles();
                            for(File file : files){
                                FileUtils.deleteQuietly(file);
                                Thread.sleep(100);
                                if(file.exists())
                                    FileUtils.forceDeleteOnExit(file);
                            }
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                }catch(InterruptedException exp){
                    exp.printStackTrace();
                }
            }
        }).start();
    }
}

class ImageRenderListener implements RenderListener { 
    /**
     * Creates a RenderListener that will look for images.
    */
    public ImageRenderListener(String path) {
        this.path = path;
        tempCount = 0;
    }

    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#beginTextBlock()
     */
    public void beginTextBlock() {}

    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#endTextBlock()
     */
    public void endTextBlock() {}

    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#renderImage(
     *     com.itextpdf.text.pdf.parser.ImageRenderInfo)
    */
    public void renderImage(ImageRenderInfo renderInfo) {
    //public void renderImage(InlineImageInfo renderInfo) {
        try {
            String filename;
            FileOutputStream os;
            PdfImageObject image = renderInfo.getImage();
            if (image == null) return;
            filename = String.format(path, ++tempCount, image.getFileType());
            os = new FileOutputStream(filename);
            os.write(image.getImageAsBytes());
            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#renderText(
     *     com.itextpdf.text.pdf.parser.TextRenderInfo)
    */
    public void renderText(TextRenderInfo renderInfo) {}
}