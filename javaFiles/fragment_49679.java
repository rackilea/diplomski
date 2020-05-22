WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
ndp.unmarshalDefaultNumbering();
AlternativeFormatInputPart inputPart = new AlternativeFormatInputPart(AltChunkType.Xhtml);
inputPart.setContentType(new ContentType("text/html"));
inputPart.setBinaryData(html.getBytes());
Relationship altChunkRel = wordMLPackage.getMainDocumentPart().addTargetPart(inputPart);
// .. the bit in document body
CTAltChunk ac = Context.getWmlObjectFactory().createCTAltChunk();
ac.setId(altChunkRel.getId());
wordMLPackage.getMainDocumentPart().addObject(ac);
// .. content type
wordMLPackage.getContentTypeManager().addDefaultContentType("html", "text/html");
//Saving the Document
wordMLPackage.save(file);