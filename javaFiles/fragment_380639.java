public PERSON mergeSafely(PERSON person) {
        Credentials originalCredentials = person.getCredentials();
        person.setCredentials(null);
        person = em.merge(person);
        person.setCredentials(originalCredentials);
        return person;
    }