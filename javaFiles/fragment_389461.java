cb.saveState();

PdfTemplate pdfTemplate = cb.createTemplate(table.getWidth(), table.getHeight());
Graphics2D g2 = pdfTemplate.createGraphics(table.getWidth(), table.getHeight());
/*g2.setColor(Color.BLACK);
g2.drawRect(x-2, y-2, table.getWidth()+2, table.getHeight()+2);*/
table.print(g2);
System.out.println("x="+x + "," + "y=" + y);
cb.addTemplate(pdfTemplate, x, y);
g2.dispose();
cb.restoreState();