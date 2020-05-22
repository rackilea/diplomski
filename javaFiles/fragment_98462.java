package scce;

import com.ximpleware.AutoPilot;
import com.ximpleware.NavException;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;
import com.ximpleware.XPathEvalException;
import com.ximpleware.XPathParseException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author David
 */
public class VTDParserExample {

    VTDGen vg;
    VTDNav vn;

    public VTDParserExample() {
        vg = new VTDGen();    
    }

    public void parseAndPrint() throws NavException {

        int level = 0;

        for(boolean el = (vn != null); 
                    el == true ;
                    el = vn.toElement(VTDNav.NEXT_SIBLING)) {

            printTag(vn, level);

            parseAndPrintChildren(level);                
        }

    } 

     private void parseAndPrintChildren(int level) throws NavException {

        vn.push();

        for(boolean el = vn.toElement(VTDNav.FIRST_CHILD); 
                    el == true ;
                    el = vn.toElement(VTDNav.NEXT_SIBLING)) {

            printTag(vn, level + 1);

            parseAndPrintChildren(level + 1);                
        }

        vn.pop();

    }

    public VTDNav loadFile(String filePath) throws IOException {

        File fDoc = new File(filePath);

        if (fDoc != null && fDoc.exists()) {
            System.out.println("loadFile file exists ["+filePath+"]");

            vg.clear();
            if (vg.parseFile(filePath, true)) {
                vn = vg.getNav();
            }
        }
        else {
            throw new IOException("File ["+filePath+"] invalid");
        }             

        if (vn == null) {                
            throw new IOException("Cannot parse file ["+filePath+"]");
        }

        return vn;
    }

    public void getElementsByXpath() {

        AutoPilot ap = new AutoPilot(vn);

        try
        {
            String xpQ = "/*";

            ap.selectXPath(xpQ);    
            if (ap.evalXPathToBoolean()) {
                ap.evalXPath();
            }
            else {
                System.out.println(this.getClass()+".getAllElements evalXPathToBoolean["+ap.evalXPathToBoolean()+"]");
            }
        }
        catch(XPathParseException | XPathEvalException | NavException e) {
            e.printStackTrace();
        }            

    }

    private void loadAttributeMap(VTDNav nav, Map<String, String>amap) {      

        nav.push();

        try {
            AutoPilot apAtt = new AutoPilot(nav);
            apAtt.selectXPath("@*");

            int j=-1;
            while ((j=apAtt.evalXPath())!=-1) {
                String name = nav.toString(j);
                String val = nav.toString(j+1);

                amap.put(name, val);
            }                     
        }
        catch(XPathParseException | XPathEvalException | NavException e) {
            e.printStackTrace();
        }

        nav.pop();        
    }     

    private void printTag(VTDNav vn, int level) throws NavException {

        String tag = vn.toString(vn.getCurrentIndex());
        System.out.print("Level ["+level+"] Tag ["+tag+"]");

        Map<String, String>amap = new LinkedHashMap<String, String>();

        loadAttributeMap(vn, amap);

        for (String aname: amap.keySet()) {
            String aval = amap.get(aname);

            System.out.print(" @"+aname+"="+aval);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        VTDParserExample vp = new VTDParserExample();

        try {

            vp.loadFile("src/scce/famedoro.xml");                                     
            vp.getElementsByXpath();
            vp.parseAndPrint();

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}