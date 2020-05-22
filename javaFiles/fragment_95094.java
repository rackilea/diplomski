public static void main(String[] args) {
        String inputDir = "C:\\tifSources";
        File faxSource = new File(inputDir);
        File file[] = faxSource.listFiles();
        System.out.println("files are " + Arrays.toString(file));
        int numImages = file.length;

        List<BufferedImage> images = new ArrayList<BufferedImage>();

        try
        {
            for (int i = 0; i < numImages; i++)
            {
                SeekableStream ss = new FileSeekableStream(file[i]);
                ImageDecoder decoder = ImageCodec.createImageDecoder("tiff", ss, null);

                int numPages = decoder.getNumPages();
                for(int j = 0; j < numPages; j++)
                {
                    PlanarImage op = new NullOpImage(decoder.decodeAsRenderedImage(j), null, null, OpImage.OP_IO_BOUND);
                    images.add(op.getAsBufferedImage());
                }
            }

            TIFFEncodeParam params = new TIFFEncodeParam();
            OutputStream out = new FileOutputStream(inputDir + "\\combined.tif"); 
            ImageEncoder encoder = ImageCodec.createImageEncoder("tiff", out, params);
            List<BufferedImage> imageList = new ArrayList<BufferedImage>();   
            for (int i = 1; i < images.size(); i++)
            {
                imageList.add(images.get(i)); 
            }
            params.setExtraImages(imageList.iterator()); 
            encoder.encode(images.get(0));
            out.close();
        }
        catch (Exception e)
        {
            System.out.println("Exception " + e);
        }
    }