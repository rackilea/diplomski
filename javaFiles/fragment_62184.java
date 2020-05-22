//Add UA XMP metadata based on specs at https://taggedpdf.com/508-pdf-help-center/pdfua-identifier-missing/
    XMPMetadata xmp = XMPMetadata.createXMPMetadata();
    xmp.createAndAddDublinCoreSchema();
    xmp.getDublinCoreSchema().setTitle(title);
    xmp.getDublinCoreSchema().setDescription(title);
    xmp.createAndAddPDFAExtensionSchemaWithDefaultNS();
    xmp.getPDFExtensionSchema().addNamespace("http://www.aiim.org/pdfa/ns/schema#", "pdfaSchema");
    xmp.getPDFExtensionSchema().addNamespace("http://www.aiim.org/pdfa/ns/property#", "pdfaProperty");
    xmp.getPDFExtensionSchema().addNamespace("http://www.aiim.org/pdfua/ns/id/", "pdfuaid");
    XMPSchema uaSchema = new XMPSchema(XMPMetadata.createXMPMetadata(),
            "pdfaSchema", "pdfaSchema", "pdfaSchema");
    uaSchema.setTextPropertyValue("schema", "PDF/UA Universal Accessibility Schema");
    uaSchema.setTextPropertyValue("namespaceURI", "http://www.aiim.org/pdfua/ns/id/");
    uaSchema.setTextPropertyValue("prefix", "pdfuaid");
    XMPSchema uaProp = new XMPSchema(XMPMetadata.createXMPMetadata(),
            "pdfaProperty", "pdfaProperty", "pdfaProperty");
    uaProp.setTextPropertyValue("name", "part");
    uaProp.setTextPropertyValue("valueType", "Integer");
    uaProp.setTextPropertyValue("category", "internal");
    uaProp.setTextPropertyValue("description", "Indicates, which part of ISO 14289 standard is followed");
    uaSchema.addUnqualifiedSequenceValue("property", uaProp);
    xmp.getPDFExtensionSchema().addBagValue("schemas", uaSchema);
    xmp.getPDFExtensionSchema().setPrefix("pdfuaid");
    xmp.getPDFExtensionSchema().setTextPropertyValue("part", "1");
    XmpSerializer serializer = new XmpSerializer();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    serializer.serialize(xmp, baos, true);
    PDMetadata metadata = new PDMetadata(pdf);
    metadata.importXMPMetadata(baos.toByteArray());
    pdf.getDocumentCatalog().setMetadata(metadata);