XMPMetadata xmp = XMPMetadata.createXMPMetadata();

XMPBasicSchema xmpschema = xmp.createAndAddXMPBasicSchema();
xmpschema.setCreatorTool(creatorTool);
xmpschema.setCreateDate(creationDate);

DublinCoreSchema dc = xmp.createAndAddDublinCoreSchema();
dc.setTitle(title);

PDFAIdentificationSchema id = xmp.createAndAddPFAIdentificationSchema();
id.setPart(1);
id.setConformance("B");
XmpSerializer serializer = new XmpSerializer();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
serializer.serialize(xmp, baos, true);
PDMetadata metadata = new PDMetadata(document);
metadata.importXMPMetadata(baos.toByteArray());
catalog.setMetadata(metadata);