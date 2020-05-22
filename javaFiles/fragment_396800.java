public class Drink implements Comparable<Drink> {

    public String name;
    @Override
    public int compareTo(Drink o) {
        return name.compareTo(o.name);
    }
    ...
}