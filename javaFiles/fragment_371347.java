File file = new File("C:\\mmmmm\\nnnnn\\nnn\\tutorial.pdf");
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,  0, channel.size());
        PDFFile pdffile = new PDFFile(buf);

        // show the first page
        PDFPage page = pdffile.getPage(0);
        panel.setClip(null);
        panel.useZoomTool(false);
        panel.showPage(page);