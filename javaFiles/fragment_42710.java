public Card(String nam, int rat, int cred) {
    if (rat > 10) {
        throw new IllegalArgumentException("Maximum rating allowed is 10. You've entered " + rat);
    }

    //Other logic here, like
    rating = rat;
}