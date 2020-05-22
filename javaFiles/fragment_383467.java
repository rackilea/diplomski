public static void main(String[] args) {
    Set<Animal> hs = new HashSet<>();
    boolean b = hs.add(new Animal());
    boolean b1 = hs.add(new Animal());
    System.out.println(b + " " + b1);
    for (Animal a : hs) {
        System.out.println(a);
    }
}