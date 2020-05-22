...
        creacionDeFooter(doc);//FOOTER CREATION METHOD

        XWPFParagraph cuerpoObservaciones = doc.createParagraph(); //PARAGRAPH 1
        cuerpoObservaciones.setAlignment(ParagraphAlignment.DISTRIBUTE);

cuerpoObservaciones.getCTP().getPPr().addNewKeepLines().setVal(STOnOff.ON); //has already a CPPr through setAlignment
cuerpoObservaciones.getCTP().getPPr().addNewKeepNext().setVal(STOnOff.ON);

        XWPFRun imprimeObservaciones = cuerpoObservaciones.createRun();            
        seccionObservaciones(doc,imprimeObservaciones,cuerpoObservaciones); //TABLE CREATION METHOD

        XWPFParagraph cuerpoFirma = doc.createParagraph();  //PARAGRAPH 2

cuerpoFirma.getCTP().addNewPPr().addNewKeepLines().setVal(STOnOff.ON);
cuerpoFirma.getCTP().getPPr().addNewKeepNext().setVal(STOnOff.ON);

        cuerpoFirma.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun imprimeFirma = cuerpoFirma.createRun();
        seccionFirma(doc,imprimeFirma,cuerpoFirma); //SIGNATURE CREATION METHOD

        doc.write(new FileOutputStream("test.docx"));
...