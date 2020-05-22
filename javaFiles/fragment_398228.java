InputStream colorProfile = new FileInputStream(colorSpacePath);
PDOutputIntent oi = new PDOutputIntent(doc, colorProfile);
oi.setInfo("sRGB IEC61966-2.1");
oi.setOutputCondition("sRGB IEC61966-2.1");
oi.setOutputConditionIdentifier("sRGB IEC61966-2.1")
oi.setRegistryName("http://www.color.org");
doc.getDocumentCatalog().addOutputIntent(oi);
colorProfile.close()