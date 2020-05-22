public class RootHandler extends DefaultHandler {
    private XMLReader reader;
    private List<Team> teams;

    public RootHandler(XMLReader reader) {
        this.reader = reader;
        this.teams = new LinkedList<Team>();
    }

    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        if (name.equals("team")) {
            // Switch handler to parse the team element
            reader.setContentHandler(new TeamHandler(reader, this));
        }
    }
}

public class TeamHandler extends DefaultHandler {
    private XMLReader reader;
    private RootHandler parent;
    private Team team;
    private StringBuilder content;

    public TeamHandler(XMLReader reader, RootHandler parent) {
        this.reader = reader;
        this.parent = parent;
        this.content = new StringBuilder();
        this.team = new Team();
    }

    // characters can be called multiple times per element so aggregate the content in a StringBuilder
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(ch, start, length);
    }

    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        content.setLength(0);
    }

    public void endElement(String uri, String localName, String name) throws SAXException {
        if (name.equals("name")) {
            team.setName(content.toString());
        } else if (name.equals("team")) {
            parent.addTeam(team);
            // Switch handler back to our parent
            reader.setContentHandler(parent);
        }
    }
}