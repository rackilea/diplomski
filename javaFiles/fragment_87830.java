DOMImplementationLS lsImp = (DOMImplementationLS)doc.getImplementation();

        LSSerializer ser = lsImp.createLSSerializer();
        ser.getDomConfig().setParameter("xml-declaration", false);

        String xml = ser.writeToString(frag1);

        System.out.println(xml);

        param.appendChild(doc.createCDATASection(xml));

        System.out.println(ser.writeToString(doc));