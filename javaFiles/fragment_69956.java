public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

    // for easy access to these values
    final int imgWidth = (int) pageFormat.getImageableWidth();
    final int imgHeight = (int) pageFormat.getImageableHeight();

    if (imgWidth <= 0) {
        throw new PrinterException("Width of printable area is too small.");
    }

    // Have we modified the column widths yet??
    if (!updateColumnWidths) {

        // Only update the column widths if the current total column width
        // is less then the available imgWidth (page width)
        if (totalColWidth < imgWidth) {

            // Calculate the required column width to allow the columns to
            // span the page...
            int columnCount = table.getColumnCount();
            int columnWidth = (int) (imgWidth / (float) columnCount);
            TableColumnModel columnModel = table.getColumnModel();
            // Update the columns...
            for (int col = 0; col < columnModel.getColumnCount(); col++) {
                TableColumn tc = columnModel.getColumn(col);
                tc.setMinWidth(columnWidth);
                tc.setMaxWidth(columnWidth);
                tc.setPreferredWidth(columnWidth);
                tc.setWidth(columnWidth);
            }
            // Update the totalColWidth, this should prevent
            // any scaling been applied
            totalColWidth = columnModel.getTotalColumnWidth();

        }
        updateColumnWidths = true;

    }
    //...