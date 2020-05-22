public final class XMLManager {


    public static ArrayList<Channel> getAlChannels(){
        ArrayList<Channel> alChannels = null;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            File file = new File("D:\\Loic_Workspace\\TestSAX2\\res\\test.xml");
            ChannelHandler channelHandler = new ChannelHandler();
            parser.parse(file, channelHandler);
            alChannels = channelHandler.getAlChannels();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return alChannels;
    }

}