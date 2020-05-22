public class Fetcher {
    private ArrayList<Pers> persons;
    private Pers person;
    private String text;

    public Fetcher() {
        persons = new ArrayList<Pers>();
    }

    public ArrayList<Quote> parse(Activity activity) throws XmlPullParserException, IOException {
        Resources resources = activity.getResources();
        XmlResourceParser xmlResourceParser = resources.getXml(R.xml.quotes);
        person = new Pers();
        xmlResourceParser.next();
        int eventType = xmlResourceParser.getEventType();
        while(eventType != XmlPullParser.END_DOCUMENT) {
            String tagName = xmlResourceParser.getName();
            switch(eventType) {
                case XmlPullParser.START_TAG: {
                    if(tagName.equalsIgnoreCase("test")) {
                        person = new Pers();
                    }
                    break;
                }

                case XmlPullParser.TEXT: {
                    text = xmlResourceParser.getText();
                    break;
                }

                case XmlPullParser.END_TAG: {
                    if(tagName.equalsIgnoreCase("test")) {
                        persons.add(person);
                    } else if(tagName.equalsIgnoreCase("name")) {
                        person.setId(Integer.parseInt(text));
                    }
                    break;
                }

                default:
                    break;
            }
            eventType = xmlResourceParser.next();
        }

        return persons;
    }
}