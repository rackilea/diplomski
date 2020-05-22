import  java.util.regex.Matcher;
import  java.util.regex.Pattern;

/**
   <P>{@code java ParseForclosureResultsXmpl}</P>
 **/
public class ParseForclosureResultsXmpl  {
   public static final void main(String[] igno_red)  {
      String sLS = System.getProperty("line.separator", "\n");

      StringBuilder sdInput = new StringBuilder().
         append("<a id=\"SheetContentPlaceHolder_ctl00_gvForeclosureResutls_lbCaseNum_0\" href=\"javascript:__doPostBack(&#39;ctl00$SheetContentPlaceHolder$ctl00$gvForeclosureResutls$ctl02$lbCaseNum&#39;,&#39;&#39;)\" style=\"display:inline-block;width:100px;\">CV-13-798497</a>").append(sLS).
         append("              </td><td align=\"center\">488-05-029</td><td align=\"center\">I</td><td align=\"center\">01/02/2013</td>").append(sLS).
         append("  </tr><tr style=\"background-color:Gainsboro;\">").append(sLS).
         append("      <td align=\"left\">UNKNOWN HEIRS, ETC OF D.C. RUFUS, ET AL  </td><td align=\"left\">10603 HAMPDEN AVENUE</td><td align=\"center\">CLEVELAND</td><td align=\"center\">44108-0000</td><td align=\"center\">").append(sLS).
         append("                  <a id=\"SheetContentPlaceHolder_ctl00_gvForeclosureResutls_lbCaseNum_1\" href=\"javascript:__doPostBack(&#39;ctl00$SheetContentPlaceHolder$ctl00$gvForeclosureResutls$ctl03$lbCaseNum&#39;,&#39;&#39;)\" style=\"display:inline-block;width:100px;\">CV-13-798498</a>").append(sLS).
         append("              </td><td align=\"center\">109-16-094</td><td align=\"center\">A</td><td align=\"center\">01/02/2013</td>").append(sLS).
         append("  </tr><tr style=\"background-color:LightGrey;\">").append(sLS).
         append("      <td align=\"left\">SHARECE MILLER, ET AL  </td><td align=\"left\">13514 ALVIN AVENUE</td><td align=\"center\">GARFIELD HTS</td><td align=\"center\">44105-0000</td><td align=\"center\">").append(sLS).
         append("                  <a id=\"SheetContentPlaceHolder_ctl00_gvForeclosureResutls_lbCaseNum_2\" href=\"javascript:__doPostBack(&#39;ctl00$Shee").append(sLS);

      String sRqdValuePrefix = "ForeclosureResutls_lbCaseNum_";
      Pattern checkerLoopPattern = Pattern.compile(sRqdValuePrefix + "\\d");
      Matcher m = checkerLoopPattern.matcher("");  //Unused. so the matcher can be reused in the loop.

      int iLn = 0;
      String[] asInput = sdInput.toString().split(sLS);
      for(String s : asInput)  {
         iLn++;    //1st iteration: Was zero, now 1

         //Resuing matcher instead of retrieving new one from Pattern each iteration
         m.reset(s);

         if(m.find())  {
            int iCheckerNumber = Integer.parseInt(s.substring(m.start() + sRqdValuePrefix.length(), m.end()));
            System.out.println("Found on line " + iLn + ", at index " + m.start() + " with checker number " + iCheckerNumber);
         }
      }
   }
}