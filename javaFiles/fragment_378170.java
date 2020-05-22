@Configuration
public class MessageBrokerInitializer {

    @Bean
    public MessageBroker getMessageBroker(){

        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        MessageBroker broker = null;
        try {
            fileInputStream = new FileInputStream("./data/store.ser");

            if(fileInputStream.available() != 0) {
              objectInputStream = new ObjectInputStream(fileInputStream);
              broker = (MessageBroker) objectInputStream.readObject();
            } else {
              broker = new MessageBroker()
           }               
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return broker;
    }
}