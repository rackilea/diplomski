public class ReadXMLFile {

        public static int ID_number_1 ;

        public static void main(String[] args) {

            for(int x=1; x<=5; x++) {

                if(x==1)
                    System.out.println("enter an integer as ID:\n");
                else 
                    System.out.println("enter your next ID:\n");

                try {
                    Scanner sc = new Scanner(System.in);

                    ID_number_1 = sc.nextInt();
                    switch (x) {
                        case 1:
                            System.out.println("we got your first id :"+ID_number_1);
                            break;
                        case 2:
                            System.out.println("we got your second id :"+ID_number_1);
                            break;
                        case 3:
                            System.out.println("we got your third id :"+ID_number_1);
                            break;
                        case 4:
                            System.out.println("we got your fourth id :"+ID_number_1);
                            break;
                        case 5:
                            System.out.println("we got your fifth id :"+ID_number_1);
                            break;  
                    }

                } catch (Exception e) {
                    System.out.println("You should enter a valid integer");
                }

                /*
                 * some process happening here;
                */
                SAXParserFactory factory = SAXParserFactory.newInstance();

                try {

                    SAXParser saxParser = factory.newSAXParser();
                    MyProjectHandler handler = new MyProjectHandler();
                    saxParser.parse("src\\SAX-XML-FAWiki.xml", handler);

                    System.out.println(handler.getFwkList());

                } catch (ParserConfigurationException | SAXException | IOException e) {
                    e.printStackTrace();
            }
            /*
             * 
            */
            System.out.println("writing in file "+ID_number_1);
        }
    }
}

public class MyProjectHandler extends DefaultHandler {


    FAWiki wiki = new FAWiki() ;
    String titlestr = null;
    String textstr = null;
    String usernamestr = null;

    boolean flag1 = false;
    boolean flag2 = false;
    boolean bid = false;
    boolean btitle = false;
    boolean btext = false;
    boolean busername = false;
    boolean match = false;
    boolean bns = false;
    boolean flag3 = false;

    public String getFwkList() {
        return wiki.toString(wiki , match);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("title")) {btitle = true;}

        if(qName.equalsIgnoreCase("ns")) {bns = true;}

        if(qName.equalsIgnoreCase("id")) {bid = true;}

        if(qName.equalsIgnoreCase("text")) {btext = true;}

        if(qName.equalsIgnoreCase("username")) {busername = true;}
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {}

    @Override   
    public void characters(char ch[], int start, int length) throws SAXException {

        if(btitle) {
            titlestr = new String(ch, start, length);
            btitle= false;
        }

        if(bid && bns) {

            int temp = Integer.parseInt(new String(ch, start, length));
            if(ReadXMLFile.ID_number_1 == temp) {

                wiki.setid(temp);
                wiki.settitle(titlestr);
                match = true;
                btext = false;
                flag1 = true;
                busername = false;
                flag2 = true;
            }    

            bns = false;
        }

        bid = false;

        if(btext && flag1) {
            textstr = new String(ch, start, length);
            wiki.settext(textstr);
            btext = false;
            flag1 = false;
        }

        if(busername && flag2) {
            usernamestr = new String(ch, start, length);
            wiki.setUsername(usernamestr);
            busername = false;
            flag2 = false;
        }
    }   
}

public class FAWiki {

    private String title;
    private int id;
    private String text;
    private String username;

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString(FAWiki fwik , Boolean match) {
        if(match) {
            return "<page>\n"+"\t<title>"+fwik.gettitle()+"</title>\n"+"\t<id>"+fwik.getid()+"</id>\n"+"\t<text>"+fwik.gettext()+"</text>\n"+"\t<username>"+fwik.getUsername()+"</username>\n"+"</page>";
        } else {
            return  "Your entered id doesn't match";
        }
    }
}