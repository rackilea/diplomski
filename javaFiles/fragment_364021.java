PageFormat defaultPage = printJob.defaultPage();

        Paper x = new Paper();
        x.setImageableArea(0, 0, height, width);
        x.setSize(height, width);
        defaultPage.setPaper(x);
        PageFormat pageFormat = defaultPage;
        printJob.setPrintable(this, pageFormat);