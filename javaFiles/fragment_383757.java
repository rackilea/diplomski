try {
    currentUser=(String) userList.nextElement();
    currentPass=(String) credentials.get(currentUser);          

} catch(NoSuchElementException nsee) {
              ^^^^^^^

    System.err.println("Is properties file blank?");
    throw new NoSuchUserException("Is properties file blank?");
                    ^^^^
}