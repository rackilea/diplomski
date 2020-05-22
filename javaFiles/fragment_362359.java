private static RepositoryConnection createRepositoryConnection() {
        if (repoistory == null) {
            prepareRepository();
        }
        RepositoryConnection con = null;
        try {
            con = repoistory.getConnection();
        } catch (RepositoryException e) {
            logger.error(
                    "Error on creating repository connection",
                    e);
        }
        return con;
    }