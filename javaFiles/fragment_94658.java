COSDictionary fdict = new COSDictionary();

fdict.setInt(COSName.FUNCTION_TYPE, 2); // still not understaning that...

COSArray domain = new COSArray();
domain.add(COSInteger.get(0));
domain.add(COSInteger.get(1));

COSArray c0 = new COSArray();
c0.add(COSFloat.get("0.64176"));
c0.add(COSFloat.get("0.72588"));
c0.add(COSFloat.get("0.78078"));

COSArray c1 = new COSArray();
c1.add(COSFloat.get("0.57176"));
c1.add(COSFloat.get("0.62588"));
c1.add(COSFloat.get("0.70078"));

fdict.setItem(COSName.DOMAIN, domain);
fdict.setItem(COSName.C0, c0);
fdict.setItem(COSName.C1, c1);
fdict.setInt(COSName.N, 1);

PDFunctionType2 func = new PDFunctionType2(fdict);

PDShadingType2 axialShading = new PDShadingType2(new COSDictionary());

axialShading.setColorSpace(PDDeviceRGB.INSTANCE);
axialShading.setShadingType(PDShading.SHADING_TYPE2);

COSArray coords1 = new COSArray();
coords1.add(COSInteger.get(0));
coords1.add(COSInteger.get(0));
coords1.add(COSInteger.get(850)); // size of my page
coords1.add(COSInteger.get(600));

axialShading.setCoords(coords1); // so this sets the bounds of my gradient
axialShading.setFunction(func); // and this determines all the curves etc?

CStr.shadingFill(axialShading); // where CStr is a ContentStream for my PDDocument