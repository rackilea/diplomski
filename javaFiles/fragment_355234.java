//Open the network connection 
        DocumentSource docSource = new DefaultDocumentSource(args[0]);

        //Parse the input document
        DOMSource parser = new DefaultDOMSource(docSource);
        Document doc = parser.parse();

        //Create the CSS analyzer
        DOMAnalyzer da = new DOMAnalyzer(doc, docSource.getURL());
        da.attributesToStyles(); //convert the HTML presentation attributes to inline styles
        da.addStyleSheet(null, CSSNorm.stdStyleSheet(), DOMAnalyzer.Origin.AGENT); //use the standard style sheet
        da.addStyleSheet(null, CSSNorm.userStyleSheet(), DOMAnalyzer.Origin.AGENT); //use the additional style sheet
        da.getStyleSheets(); //load the author style sheets

        //Compute the styles
        System.err.println("Computing style...");
        da.stylesToDomInherited();

        //Save the output
        PrintStream os = new PrintStream(new FileOutputStream(args[1]));
        Output out = new NormalOutput(doc);
        out.dumpTo(os);
        os.close();

        docSource.close();