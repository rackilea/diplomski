public class MyMain {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Enclosure enclosure = null;
        for(Channel channel : XMLManager.getAlChannels()){
            System.out.println("Channel title : "+channel.getTitle());
            System.out.println("------------------------");
            for(Item i:channel.getAlItems()){
                System.out.println(i.getTitle());
                System.out.println(i.getPubDate());
                System.out.println("Enclosure : ");
                enclosure = i.getEnclosure();
                System.out.println(enclosure.getType());
                System.out.println(enclosure.getUrl());
                System.out.println(enclosure.getLength());
                System.out.println("------------------------");
            }
        }




    }

}