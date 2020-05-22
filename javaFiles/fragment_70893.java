public HeaderServiceCall<NewUser, RegUserStatus> addUser(String id) {

    return (reqHeaders, postedUser) -> {
        System.out.println(reqHeaders.getHeader("Referer"));
        PersistentEntityRef<UserCommand> ref = persistentEntityRegistry.refFor(UserEntity.class, id);
        return ref.ask(new UserCommand.RegisterUser(id, postedUser)).thenApply( stat -> Pair.create(ResponseHeader.OK, stat));
    };
}