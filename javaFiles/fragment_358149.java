@Autowired 
ClientDAO clientDAO;

public Client findClientByUsername(String username){
      return clientDAO.findByUsername(username);
}

public boolean isUsernameUnique(String username) {
    Client client = findClientByUsername(username);
     return (client == null || ((username != null) && client.getUsername() == username));