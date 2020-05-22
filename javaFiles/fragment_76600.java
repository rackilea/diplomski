import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class RSSReader {

    public static void main(String[] args) {
        try {
            File f = new File("testrss.xml");
            if (f.isFile()) {
                System.out.println("is File");
                List<RSSChannel> channels = read(f);
                for (RSSChannel channel: channels) {
                    System.out.println("Channel: ");
                    System.out.println("    title: " + channel.getTitle());
                    System.out.println("    link: " + channel.getLink());
                    System.out.println("    description: " + channel.getDescription());
                    for (RSSItem item: channel.getItems()) {
                        System.out.println("    Item: ");
                        System.out.println("        title: " + item.getTitle());
                        System.out.println("        link: " + item.getLink());
                        System.out.println("        description: " + item.getDescription());
                        System.out.println("        pubDate: " + item.getPubDate());
                        System.out.println("        guid: " + item.getGuid());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<RSSChannel> read(File xmlFile)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile); // Document extends Node

        Element root = doc.getDocumentElement();
        if (!root.getTagName().equalsIgnoreCase("rss")) {
            throw new IOException("Invalid RSS document");
        }

        return readChannels(root.getChildNodes());
    }

    private static List<RSSChannel> readChannels(NodeList nodes) {
        List<RSSChannel> result = new ArrayList<RSSChannel>();
        for (int i = 0; i < nodes.getLength(); ++i) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element elem = (Element)node;
                if (elem.getTagName().equalsIgnoreCase("channel")) {
                    result.add(readChannel(elem.getChildNodes()));
                }
            }
        }
        return result;
    }

    private static RSSChannel readChannel(NodeList nodes) {
        RSSChannel channel = new RSSChannel();
        for (int i = 0; i < nodes.getLength(); ++i) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element elem = (Element)node;
                if (elem.getTagName().equalsIgnoreCase("title")) {
                    channel.setTitle(getText(elem));
                } else if (elem.getTagName().equalsIgnoreCase("link")) {
                    channel.setLink(getText(elem));
                } else if (elem.getTagName().equalsIgnoreCase("description")) {
                    channel.setDescription(getText(elem));
                } else if (elem.getTagName().equalsIgnoreCase("item")) {
                    channel.addItem(readItem(elem.getChildNodes()));
                }
            }
        }
        return channel;
    }

    private static RSSItem readItem(NodeList nodes) {
        RSSItem item = new RSSItem();
        for (int i = 0; i < nodes.getLength(); ++i) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element elem = (Element)node;
                if (elem.getTagName().equalsIgnoreCase("title")) {
                    item.setTitle(getText(elem));
                } else if (elem.getTagName().equalsIgnoreCase("link")) {
                    item.setLink(getText(elem));
                } else if (elem.getTagName().equalsIgnoreCase("description")) {
                    item.setDescription(getText(elem));
                } else if (elem.getTagName().equalsIgnoreCase("pubDate")) {
                    item.setPubDate(getText(elem));
                } else if (elem.getTagName().equalsIgnoreCase("guid")) {
                    item.setGuid(getText(elem));
                }
            }
        }
        return item;
    }

    private static String getText(Element elm) {
        Node node = elm.getFirstChild();
        if (!(node instanceof Text)) {
            return null;
        }
        Text text = (Text)node;
        return text.getData().trim();
    }

    public static class RSSChannel {

        public RSSChannel() {
            this.title = "";
            this.link = "";
            this.description = "";
        }

        public RSSChannel(String title, String link, String description) {

            this.title = title;
            this.link = link;
            this.description = description;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getDescription() {
            return description;
        }

        public List<RSSItem> getItems() {
            return new ArrayList<RSSItem>(items);
        }

        public void addItem(RSSItem item) {
            items.add(item);
        }

        private String title;
        private String link;
        private String description;
        private List<RSSItem> items = new ArrayList<RSSItem>();
    }

    public static class RSSItem {

        public RSSItem() {

            this.title = "";
            this.link = "";
            this.description = "";
            this.pubDate = "";
            this.guid = "";
        }

        public RSSItem(String title, String link, String description, String item, String pubDate, String guid) {

            this.title = title;
            this.link = link;
            this.description = description;
            this.pubDate = pubDate;
            this.guid = guid;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getGuid() {
            return guid;
        }

        public String getLink() {
            return link;
        }

        public String getPubDate() {
            return pubDate;
        }

        private String title;
        private String link;
        private String description;
        private String pubDate;
        private String guid;
    }
}