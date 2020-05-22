PdfContentByte cb = writer.getDirectContentUnder();
document.add(getWatermarkedImage(cb, Image.getInstance(IMAGE1), "Bruno"));
document.add(getWatermarkedImage(cb, Image.getInstance(IMAGE2), "Dog"));
document.add(getWatermarkedImage(cb, Image.getInstance(IMAGE3), "Fox"));
Image img = Image.getInstance(IMAGE4);
img.scaleToFit(400, 700);
document.add(getWatermarkedImage(cb, img, "Bruno and Ingeborg"));