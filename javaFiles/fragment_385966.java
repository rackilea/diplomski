//JDesktopPane desktop = new JDesktopPane();
JInternalFrame internalFrame = new JInternalFrame("PDFAnnotation" + index, true, true, true, true);

internalFrame.setBounds(0, 0, 600, 100);

desktop.add(internalFrame);

PDFPanel p = new PDFPanel();
JPanel e = p.getJPanel();
internalFrame.add(e, BorderLayout.CENTER);
internalFrame.setVisible(true);
//this.add(desktop, BorderLayout.CENTER);