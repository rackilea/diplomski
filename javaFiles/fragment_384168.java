public class CopyVisitor implements Visitor {

    private Visited copy;

    @Override
    public void visitHuman(Human human) {
        copy = Human.builder()
                    .name(human.getName())
                    .age(human.getAge())
                    .build();

    }

    @Override
    public void visitCar(Car car) {
        copy = Car.builder()
                  .model(car.getModel())
                  .brand(car.getBrand())
                  .build();
    }

    @Override
    public void visitPlanet(Planet planet) {
        //...
    }

    public Visited getCopy() {
        return copy;
    }

}