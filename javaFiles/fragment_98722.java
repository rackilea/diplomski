// extract from IOConsoleWriterImpl

public IOConsoleWriterImpl(Writer writer) {
    this.writer = writer;
}

public void displayAllClientsInfo(ClientEntity clients) {
    for (ClientEntity client : clients) {
        System.out.println(client.getName());
        List<AccountEntity> accounts = client.getAccountEntities();
        for (AccountEntity account : accounts){
            writer.write(account.getLogin());
        }
    }
}

// a new interface to extract the 'writing' behaviour out of IOConsoleWriterImpl
public interface Writer {
    void write(String output);
}

// a sysout implementation of the Writer interface
public class SystemOutWriter implements Writer {
    @Override
    public void write(String output) {
        System.out.println(output);
    }
}