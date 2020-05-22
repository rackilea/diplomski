class Sensor<T extends Enum<T>> {
    T status;
    protected Sensor(T status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status.toString();
    }
}

class Device extends Sensor<Device.Status> {
    enum Status {On, Off}
    public Device() {
        super(Status.On);
    }
}

class Device2 extends Sensor<Device2.Status> {
    enum Status { OPEN, CLOSED, LOCKED }

    Device2() {
        super(Status.OPEN);
    }
}