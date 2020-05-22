interface UserVisitor {
    public void visit(ConcreteUser1 user1);

    public void visit(ConcreteUser2 user2);
}


static class VehicleVisitor implements UserVisitor {

    private Vehicle vehicle;
    private Bus bus;

    VehicleVisitor(Vehicle vehicle, Bus bus) {
        this.vehicle = vehicle;
        this.bus = bus;
    }

    public void visit(ConcreteUser1 user1) {
        user1.setVehicle(vehicle);
    }

    public void visit(ConcreteUser2 user2) {
        user2.setBus(bus);
    }
}

static abstract class AbstractUser {
    public abstract void accept(VehicleVisitor visitor);
}

static class ConcreteUser1 extends AbstractUser {

    private Vehicle vehicle;

    public void accept(VehicleVisitor visitor) {
        visitor.visit(this);
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

static class ConcreteUser2 extends AbstractUser {

    private Bus bus;

    public void accept(VehicleVisitor visitor) {
        visitor.visit(this);
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Bus getBus() {
        return bus;
    }
}

static class Vehicle {

    @Override
    public String toString() {
        return "CAR";
    }
}
static class Bus {

    @Override
    public String toString() {
        return "BUS";
    }
}

public static void main(String[] args) {
    List<AbstractUser> users = new ArrayList<AbstractUser>();
    ConcreteUser1 user1 = new ConcreteUser1();
    users.add(user1);
    ConcreteUser2 user2 = new ConcreteUser2();
    users.add(user2);

    for (AbstractUser user : users) {
        VehicleVisitor visitor = new VehicleVisitor(new Vehicle(), new Bus());
        user.accept(visitor);
    }

    System.out.println(user1.getVehicle());
    System.out.println(user2.getBus());
}