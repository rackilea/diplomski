import com.ximpleware.*;

public class insertTextNode {
    public static void main(String[] s) throws VTDException, Exception {
        VTDGen vg = new VTDGen();
        AutoPilot ap = new AutoPilot();
        XMLModifier xm = new XMLModifier();
        if (vg.parseFile("input.xml", true)) {
            VTDNav vn = vg.getNav();
            ap.bind(vn);
            xm.bind(vn);
            ap.selectXPath("/body/request/location/address");
            int i=0;
            while((i=ap.evalXPath())!=-1){
                xm.insertAfterHead("myAddress");
            }
            xm.output("output.xml");
        }
    }
}