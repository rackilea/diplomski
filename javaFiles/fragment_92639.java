// what you want the upper layers to see
interface Client {
    void addAddress(address);
}

// the actual implementations
public class ClientAggregate implements Client 
{
    void rehidrate(clientId,name,address){...}
    void addAddress(address){...}
}

public class ClientRepository
{
    // this method returns Client (interface)
    Client getById(id){
        val clientEntity = em.find(...)
        val client = new ClientAggregate()
        client.rehydrate(clientEntity.id, clientEntity.name, clientEntity.address)
        return client //you are returning ClientAggregate but the other see only Client (interface)
    }
}