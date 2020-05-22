@Service
public class ClientManagerFactory implements Factory<ClientManager> {

    @Override @Singleton
    public ClientManager provide() {
        return ClientManager.fromSettings();
    }

    @Override
    public void dispose(ClientManager instance) {
        instance.cleanupResources();
    }

}