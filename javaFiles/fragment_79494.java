File file = new File("test.pdf");
RandomAccessFile raf = new RandomAccessFile(file, "r");
FileChannel channel = raf.getChannel();
ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
PDFFile pdffile = new PDFFile(buf);

// draw the first page to an image
PDFPage page = pdffile.getPage(0);

//get the width and height for the doc at the default zoom 
Rectangle rect = new Rectangle(0,0,
                (int)page.getBBox().getWidth(),
                (int)page.getBBox().getHeight());

//generate the image
Image img = page.getImage(
                rect.width, rect.height, //width & height
                rect, // clip rect
                null, // null for the ImageObserver
                true, // fill background with white
                true  // block until drawing is done
                );