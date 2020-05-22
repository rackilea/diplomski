signatureProperties.signerName(name).signerLocation(location)
            .signatureReason(reason).preferredSize(0).page(1)
            .visualSignEnabled(true).setPdVisibleSignature(signatureDesigner);

    PDFTemplateBuilder builder = new ExtSigBuilder();
    PDFTemplateCreator creator = new PDFTemplateCreator(builder);
    signatureProperties.setVisibleSignature(creator.buildPDF(signatureProperties.getPdVisibleSignature()));