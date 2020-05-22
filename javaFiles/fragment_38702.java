import org.jsoup.nodes.*;

Document doc = Jsoup.parse("");
// clear <html><body></body></html>
doc.html("");

Element e = doc.appendElement("body").appendElement("resources");

e = e.appendElement("string-array");
e.attr("name", "mytest");

for (int i = 0; i < 10; i++) {
    Element sub = e.appendElement("item");
    sub.attr("number", Integer.toString(i));
    sub.appendElement("name").text("blahh");
}