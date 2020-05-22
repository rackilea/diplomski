public final class Items {
    public final int id;
    public final String from;
    public final String to;

    private Items(int id, String from, String to) {
        this.id=id;
        this.from=from;
        this.to=to;
    }

    public static Items create(int id, String from, String to) {
        // check that id is in a valid range
        if(id <= 10 || id >= 100){
            throw new IllegalArgumentException("Id must be between 10 and 100");
        }

        // here you can check "from" and "to" too and check that they are valid

        // if no exception has been thrown 
        // then we can safely say that the arguments are valid
        return new Items(id, from, to);
    }
}