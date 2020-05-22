public class FreeSwitchEslClientFactory extends BasePooledObjectFactory<Client> {

    @Override
    public Client create() throws Exception {
        //Create and connect: NOTE I'M NOT AN EXPERT OF ESL FREESWITCH SO YOU MUST CHECK IT PROPERLY
        Client client = new Client();
        client.connect("127.0.0.1", 8021 , "password", 10);
        client.setEventSubscriptions("plain", "all");
        return client;
    }

    @Override
    public PooledObject<Client> wrap(Client obj) {

        return new DefaultPooledObject<Client>(obj);
    }
}