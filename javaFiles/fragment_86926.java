return actorDao.readAll()
        .stream()
        .filter(actor -> firstName.equalsIgnoreCase(actor.getFirstName()))
        .filter(actor -> lastName.equalsIgnoreCase(actor.getLastName()))
        .map(actor -> actorDao.read(actor.getId() - 1).get())
        .findFirst()
        .orElse(null);