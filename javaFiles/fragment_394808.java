am.put("Print", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            System.out.println("Print...");
            BufferedImage img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            frame.printAll(g2d);
            g2d.dispose();
            PrinterJob pj = PrinterJob.getPrinterJob();
            pj.setPrintable(new FramePrintable(img));
            if (pj.printDialog()) {
                pj.print();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});