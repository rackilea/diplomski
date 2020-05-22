package Scrapper;

import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeVisitor;

class TagVisitor implements NodeVisitor {

    public static class TagInfo {

        public String name;
        public int depth;

        TagInfo(String name, int depth) {
            this.depth = depth;
            this.name = name;
        }
    }

    private LinkedList<TagInfo> tags = new LinkedList<>();

    public void head(Node node, int depth) {
        String tag = node.nodeName();
        if(!tag.startsWith("#")) {
            tags.add(new TagInfo('<'+node.nodeName()+'>', depth)); 
        }
    }

    public void tail(Node node, int depth) {
        //Do nothing
    }

    public LinkedList<TagInfo> getTags() {
        return tags;
    }

    public void printTree() {
        for(TagInfo info : tags) {
            String indentation = new String(new char[info.depth*2]).replace('\0', ' ');
            System.out.println(indentation + info.name);
        }
    }
}

public class MainJsoup {

    public static void main(String[] args) throws Exception {

        //InputStream stream = new FileInputStream("test.html");
        //Document doc = Jsoup.parse(stream, "UTF-8", "");
        String URL ="http://csb.stanford.edu/class/public/pages/sykes_webdesign/05_simple.html";
        Document doc = Jsoup
                        .connect(URL)
                        .userAgent("Mozilla/5.0 (Windows; U; Windows NT 6.1; rv:2.2) Gecko/20110201")
                        .timeout(2000)
                        .get();     
        TagVisitor visitor = new TagVisitor();
        doc.traverse(visitor);
        visitor.printTree();
    }
}