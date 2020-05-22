@Component
public class FreeSwitchEslCommandSender {

    @Autowired
    @Qualifier("clientPool")
    private GenericObjectPool<Client> pool;

    public void sendCommand(String command, String param) throws Exception{
        Client client = null;
        try {
            client = pool.borrowObject();
            client.sendSyncApiCommand(command, param);
        } finally {
            if( client != null ) {
                client.close();
            }
            pool.returnObject(client);
        }
    }
}