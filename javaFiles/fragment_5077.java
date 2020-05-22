Document document = (Document) new SAXBuilder().build(new File("E:/input.xml"));
            Element sub = document.getRootElement().getChild("project").getChild("Sub");            
            Element second = new Element("second");
            second.setAttribute("property1", "aa");
            second.setAttribute("property2", "dd");

            sub.addContent(second);

            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat().setOmitDeclaration(true));         
            xmlOutput.output(document, System.out);