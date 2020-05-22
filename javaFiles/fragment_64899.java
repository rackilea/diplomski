PDPageContentStream stream = new PDPageContentStream(doc, page);
stream.setFont(font, 12);
stream.beginText();
stream.moveTextPositionByAmount(30, 600);
stream.drawString("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
stream.moveTextPositionByAmount(0, -20);
stream.drawString("abcdefghijklmnopqrstuvwxyz");
stream.moveTextPositionByAmount(0, -20);
stream.drawString("0123456789");
stream.endText();
stream.close();

doc.save("embedFont.pdf");