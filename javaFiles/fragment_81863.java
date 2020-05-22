import com.ximpleware.*;
public class openAndTest{
   public static void main(String[] s) throws VTDException{
        // open the XML file
        VTDGen vg = new VTDGen();
        if (!vg.parseFile("input.xml", false) ) // namespace disabled here
           return;
        VTDNav vn = vg.getNav(); 
        AutoPilot ap = new AutoPilot(vn); //bind to vn object
        ap.selectXPath("/CdtTrfTxInf/PmtId/EndToEndId"); // dont put xpath compilation in loop
        System.out.println(" test result is "+ap.evalXPathToBoolean());
        ap.selectXPath("/CdtTrfTxInf/PmtId/EndToEndId"); // reuse AP, but you can instantiate a separate AutoPilot object.
        System.out.println(" test result is "+ap.evalXPathToBoolean());

   }
}