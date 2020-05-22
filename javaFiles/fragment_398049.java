public class MyOptreden extends Optreden
{
    private String name;

    public MyOptreden(String name, String stage, int hour, int minutes, int rating) {
        super(name, stage, hour, minutes, rating);
        this.name = name; // A capture name here
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MyOptreden && ((MyOptreden) obj).name.equals(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}