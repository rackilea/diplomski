abstract class Sensor {
    public abstract String getStatus();
}

class Device extends Sensor {
    enum Status {On, Off}
    Status status = Status.On;

    public String getStatus() {
        return this.status.toString();
    }
}

class Device2 extends Sensor {
    enum Status { OPEN, CLOSED, LOCKED }
    Status status = Status.OPEN;
    public String getStatus() {
        return this.status.toString();
    }
}