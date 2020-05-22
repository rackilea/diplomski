public PERSON mergeCompletely(PERSON person) {
        Credentials mergedCredentials = credentialsDAO.merge(person.getCredentials());
        person.setCredentials(mergedCredentials);
        person = personDAO.merge(person);
        return person;
    }