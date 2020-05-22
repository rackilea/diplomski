public static void main(String s[]) throws Exception{
     VTDGenHuge vg = new VTDGenHuge();
        if (vg.parseFile("d:\\xml\\sku_extract_main.xml",true,VTDGenHuge.MEM_MAPPED)) {
            VTDNavHuge vnh = vg.getNav();
            AutoPilotHuge aph = new AutoPilotHuge(vnh);
            AutoPilotHuge aph2 = new AutoPilotHuge(vnh);
            aph.selectElementNS("*", "*");
            aph2.selectXPath("@*");
            int i = 0;
            while (aph.iterate()) {
                System.out.println(vnh.toString(vnh.getCurrentIndex()));
                int t = vnh.getText();
                if (t != -1) {
                    System.out.println(vnh.toString(vnh.getCurrentIndex()) + "|||" + vnh.toNormalizedString(t));
                    i++;
                }

// below is the my addition
// it basically evaluates the attribute axis
// push pop ensure that the node iteration of the outer while loop
// is consistent
// resetXPath is key here, without it, xpath will not work except for the
// first node returned by aph.iterate()
                vnh.push();

                while((i=aph2.evalXPath())!=-1){
                    System.out.println(" attr name "+vnh.toString(i));
                    System.out.println("attr val   "+vnh.toString(i+1));
                }
                aph2.resetXPath();
                vnh.pop();
            }
}