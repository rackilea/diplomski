@ApiMethod(name = "storeUserModel")
    public UserModel storeUserModel(UserModel userModel) throws UserAlreadyExistsException, UserNotFoundException {
        logger.info("inside storeUser");
        String email = userModel.getEmail();
        UserModel checkUser = getUserModel(email);
        logger.info("after getUserModel with email " + email);

        if (checkUser == null) {
            logger.info("inside checkUser is NULL");
            DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
            Transaction txn = datastoreService.beginTransaction();
            try {
                Entity userEntity = new Entity(UserModel.class.getSimpleName(), email);
                userEntity.setProperty("nickname", userModel.getNickname());

                // TODO save the pheromones with the key of userEntity
                datastoreService.put(userEntity);
                txn.commit();
                storePheromoneList(userModel.getPheromoneList(), userEntity.getKey(), datastoreService);
            } finally {
                if (txn.isActive()) {
                    logger.severe("rolled back with email : " +  email);
                    txn.rollback();
                }
            }
        }
        else {
            throw new UserAlreadyExistsException();
        }
        return userModel;

    }