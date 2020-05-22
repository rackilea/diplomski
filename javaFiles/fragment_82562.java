public class ChannelHandler extends DefaultHandler{

    private ArrayList<Channel> alChannels;
    private Channel channel;
    private String reading;
    private ArrayList<Item> alItems;
    private Item item;
    private Enclosure enclosure;

    public ChannelHandler(){
        super();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {

        if(qName.equals("rss")){
                alChannels = new ArrayList<>();
        }
        else if(qName.equals("channel")){
            channel = new Channel();
        }
        else if(qName.equals("item")){
            item = new Item();
        }
        else if(qName.equals("enclosure")){

            enclosure = new Enclosure();
            enclosure.setType(attributes.getValue("type"));
            try {
                enclosure.setUrl(new URL(attributes.getValue("url")));
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            enclosure.setLength(Integer.parseInt(attributes.getValue("length")));

        }

    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if(qName.equals("channel")){
            channel.setAlItems(alItems);
            alChannels.add(channel);
            alItems = null;
        }
        if(qName.equals("title")){

            if(alItems == null){
                channel.setTitle(reading);
                alItems = new ArrayList<>();
            }
            else if(item != null) {
                item.setTitle(reading);
            }

        }
        else if(qName.equals("item")){

            if(alItems != null){
                alItems.add(item);
                item = null;
            }

        }
        else if(qName.equals("description")){
            item.setDescription(reading);
        }
        else if(qName.equals("pubDate")){
            item.setPubDate(reading);
        }
        else if(qName.equals("enclosure")){
            item.setEnclosure(enclosure);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        reading = new String(ch, start, length);
    }

    public ArrayList<Channel> getAlChannels() {
        return alChannels;
    }


}