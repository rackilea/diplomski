import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class sssaa {
    public static void main(String[] args) throws Exception {
        String xml = "yourXML";        
        Document doc = Jsoup.parse(xml);
        Elements StatusDocuments = doc.select("StatusDocument");
        for(Element e : StatusDocuments){
            if(e.select("Description").text().equals("Invoice")){
                System.out.println(e.select("DocumentID").text());
            }           
        }
    }
}