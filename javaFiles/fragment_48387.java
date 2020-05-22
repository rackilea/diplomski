public class Appartement {
    private String id;
    ....

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Appartement)) return false;
        return this.id.equals(((Appartement)obj.id));
    }

    @Override
    public int hashCode() {

       return 123123131311; //replace to your own hashcode.
    } 
}