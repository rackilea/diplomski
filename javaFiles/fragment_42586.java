import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class JSoupChangeDom {
    public static void main(String[] args) {
        Document doc = Jsoup.parse(""+
        " <html><body>                                            " +
        " <div>example</div>                                      " +
        " <form>                                                  " +
        "    <select name='mySelect'>                             " +
        "       <option value='Option1'>Option 1</option>         " +
        "       <option value='Option2'>Option 2</option>         " +
        "       <option value='Option3'>Option 3</option>         " +
        "    </select>                                            " +
        " <form>                                                  " +
        " </body></html>                                          ");
        Element mySelect = 
                      doc.getElementsByAttributeValue("name", "mySelect").get(0);
        String optionValueToBeSelected = "Option2";
        Elements options = mySelect.getElementsByTag("option");
        for (Element option : options) {
            if (option.attr("value").equals(optionValueToBeSelected)) {
                option.attr("selected", "selected");
            } else {
                option.removeAttr("selected");
            }
        }
        System.out.println(doc);
    }
}