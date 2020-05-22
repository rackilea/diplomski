import org.json.JSONObject;
import org.json.XML;

String xmlString = "<detail>&lt;P&gt;Students should avoid purchasing their textbooks at the first store that they browse. Instead, they should investigate the alternatives offered by other online booksellers. Price isn't the only factor to consider when making an online purchase. Students should also factor in shipping costs and delivery time when making their buying decision.&lt;/P&gt;</detail>";
System.out.println("Initial XML : " + xmlString);
JSONObject jsonObj = (XML.toJSONObject(xmlString));
System.out.println("Converted JSON : " + jsonObj.toString());
System.out.println("Back to converted XML : " + XML.toString(jsonObj));