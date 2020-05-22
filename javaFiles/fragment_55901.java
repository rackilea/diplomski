import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupTest {

    public static void main(String[] args) throws IOException {
       Document tunisie = Jsoup.connect("http://www.juricaf.org/arret/TUNISIE-COURDECASSATION-20060126-5216").get();
       // get the first div in class arret
       Element arret = tunisie.select("div.arret").first();   
       // select h1 tag by its ID to get the title 
       String  titre = arret.select("#titre").text();
       System.out.println(titre);
       // to get the text after h3 select h3 and go to next sibling
       String txtAfterFirstH3    = arret.select("h3").first().nextSibling().toString();
       System.out.println(txtAfterFirstH3);
       // select first br by its index; note first br has the index 0; and call nextSibling to get the text after the br tag
       String txtAfterFirstBr    = arret.getElementsByTag("br").get(0).nextSibling().toString();
       System.out.println(txtAfterFirstBr);
       // the same as above only with next index
       String txtAfterSecondBr    = arret.getElementsByTag("br").get(1).nextSibling().toString();
       System.out.println(txtAfterSecondBr);
    } 
}