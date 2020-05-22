Image image1 = ImageIO.read(new File("D:\\b.jpg"));
    BufferedImage buffered = (BufferedImage) image1;


    JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);
    jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
    jpegParams.setCompressionQuality(1f);
    IIORegistry registry = IIORegistry.getDefaultInstance();

    Iterator<ImageWriterSpi> services = registry.getServiceProviders(ImageWriterSpi.class,
                                             new ServiceRegistry.Filter() {   
    @Override
    public boolean filter(Object provider) {
        if (!(provider instanceof ImageWriterSpi)) return false;

        ImageWriterSpi writerSPI = (ImageWriterSpi) provider;
        String[] formatNames = writerSPI.getFormatNames();
        for (int i = 0; i < formatNames.length; i++) {
            if (formatNames[i].equalsIgnoreCase("JPEG")) {
                return true;
            }
        }

        return false;
    }
},
true);
ImageWriterSpi writerSpi = services.next();
ImageWriter writer = writerSpi.createWriterInstance();


writer.setOutput(new FileImageOutputStream(new File("D:\\1.jpg")));



BufferedImage b1=buffered.getSubimage(0, 0, (buffered.getWidth()/2), buffered.getHeight());

writer.write(null, new IIOImage((RenderedImage) b1, null, null), jpegParams);


ImageWriter writer1 = writerSpi.createWriterInstance();
BufferedImage b2=buffered.getSubimage(buffered.getWidth()/2, 0, buffered.getWidth()/2, buffered.getHeight());
writer1.setOutput(new FileImageOutputStream(new File("2.jpg")));

writer1.write(null, new IIOImage((RenderedImage) b2, null, null), jpegParams);