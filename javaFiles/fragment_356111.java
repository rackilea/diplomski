Git result = Git.cloneRepository()
            ....
            .call();

    try {
        ...
    } finally {
        result.close();
    }