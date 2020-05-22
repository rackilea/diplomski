public interface Animal {

    String getName();

    ArrayList<? extends Animal> getPack();

}