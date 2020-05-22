protected void exportElements(List<JRPrintElement> elements) {
    for (int i = 0; i < elements.size(); i++) {
        Object element = elements.get(i);
        if (element instanceof JRPrintText) {
            exportText((JRPrintText) element);
        } else if (element instanceof JRPrintFrame) {
            JRPrintFrame frame = (JRPrintFrame) element;
            setFrameElementsOffset(frame, false);
            try {
                exportElements(frame.getElements());
            } finally {
                restoreElementOffsets();
            }
        }
    }