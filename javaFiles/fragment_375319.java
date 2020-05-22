cb.saveState();
PdfTemplate pdfTemplate = cb.createTemplate(750,750);
Graphics2D g2 = pdfTemplate.createGraphics(750, 750);
Drawer drawer = new Drawer();
drawer.setSource(new File(jTextField1.getText()));
drawer.paintComponent(g2);
cb.addTemplate(pdfTemplate, 10, 10);
g2.dispose();
cb.restoreState();