String s = "<pn category=\"ONE\" GENERAL0=\"0\" GENERAL1=\"-1\" >previoustext</pn>";
        vg.setDoc(s.getBytes());
        vg.parse(true);
        vn = vg.getNav();
        AutoPilot testAP = new AutoPilot(vn);
        testAP.selectXPath("/pn[@category]"); 
        xm.bind(vn);
        int j; 
        while((j = testAP.evalXPath()) != -1) 
        { 
             int p = vn.getText(); 
             xm.updateToken(p, "new text"); 
        } 
        XMLByteOutputStream xbos =new XMLByteOutputStream(xm.getUpdatedDocumentSize());
        xm.output(xbos);
        System.out.println(new String(xbos.getXML()));