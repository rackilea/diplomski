public class Bookdetails {
    private int id;
    //other attributes and methods...

    @Override
    public boolean equals(Object o) {
        if (o instanceof Bookdetails) {
            Bookdetails oBookdetails = (Bookdetails)o;
            return (this.id == oBookdetails.id);
        }
        return false;
    }
}