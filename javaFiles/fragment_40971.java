class Toy
{
    final ToyData data;

    public Toy(ToyData data) { this.data = data; }

    public ToyData getData() { return data; }
}

interface ToyData { } 

interface Colored
{
    Color getColor();
}

class Bike implements ToyData, Colored
{
    @Override public Color getColor() { return Color.WHITE; }
}

class Skateboard implements ToyData, Colored
{
    @Override public Color getColor() { return Color.BLACK; }
}

class Ship implements ToyData { }


public static void main (String[] args) throws java.lang.Exception
{
    List<Toy> toys = new ArrayList<>();

    toys.add(new Skateboard());
    toys.add(new Bike());
    toys.add(new Ship());

    Set<Color> = toys.stream()
                     .map(Toy::getData)
                     .filter(t -> t instanceof Colored)
                     .map(t -> ((Colored)t).getColor())
                     .collect(Collectors.toSet());
}