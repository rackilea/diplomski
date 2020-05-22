Map<String, List<PublicKey>> userKeysMap = new HashMap<>();
List<String> users = Arrays.asList("Jim", "Sally", "Bob");
for(String user : users){
    List<PublicKey> usersKeys = new ArrayList<>();
    for(AuthorizedKeyEntry ake : AuthorizedKeyEntry.readAuthorizedKeys(new File(user + "_authorized_keys"))){
        PublicKey publicKey = ake.resolvePublicKey(PublicKeyEntryResolver.IGNORING);
        if(publicKey != null){
            usersKeys.add(publicKey);
        }
    }
    userKeysMap.put(user, usersKeys);
}