String count= "Foo";
           String interval= "Dummy";       
           String attribute  = " count=\""+ foo + "\" interval=\""+ interval+"\"";
            if (vg.parseFile("C:\\Users\\_myPath_\\myFile.xml", true)) {
                VTDNav vn = vg.getNav();
                ap.bind(vn);
                xm.bind(vn);
                ap.selectXPath("/*[name()='task']/*[name()='trigger']");
                int i=0;
                while((i=ap.evalXPath())!=-1){
                    xm.insertAttribute(attribute);
                }
                xm.output("C:\\Users\\_myPath_\\myFileWithFoo.xml");
                System.out.println(vg+attribute);
            }