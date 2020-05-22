public List<User> getUserListByClient(Client c)
{

     Client client = em.find(Client.class, c.clientId);
     return client.getUserList();

}