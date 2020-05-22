public class Observatory {

    private final String obsname;

    public Observatory(String obsname) {
        this.obsname = obsname;
    }

    public String getObsname() {
        return obsname;
    }

    @Override
    public String toString() {
        return obsname;
    }
}