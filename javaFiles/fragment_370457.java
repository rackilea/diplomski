public static void main1(String args[]) {
    try {
        VTDGen vg = new VTDGen();
        if (vg.parseFile("C:\\..\\example.xml", true)) {
            VTDNav vn = vg.getNav();
            AutoPilot ap = new AutoPilot(vn);
            ap.selectXPath("/Parents/process");
            int  chunk = 0;
            FileOutputStream fopsA=(new FileOutputStream("C:\\....\\resultA" + chunk + ".xml"));
            fopsA.write("<Parent>\n".getBytes());
            FileOutputStream fopsB=(new FileOutputStream("C:\\....\\resultB" + chunk + ".xml"));
            while (( ap.evalXPath()) != -1) {
                long frag = vn.getElementFragment();
                int i=vn.getAttrVal("Child");
                if (i==-1) throw new NavException("unexpected result");
                if  (vn.compareTokenString(i,"A")==0){

                    fopsA.write(vn.getXML().getBytes(), (int) frag,
                        (int) (frag >> 32));

                }else if  (vn.compareTokenString(i,"B")==0){

                    fopsB.write(vn.getXML().getBytes(), (int) frag,
                            (int) (frag >> 32));
                }
                chunk++;
            }

            fopsA.write("</Parent>\n".getBytes());
            fopsB.write("</Parent>\n".getBytes());
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }