class Meter{
    int id;
    String name;
    String serial;
    String status;
    double chargingCurrent;
    String address;
    double  meterReading;

    public Meter(List<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.name = data.get(1);            
        this.serial = data.get(2);
        this.status = data.get(3);
        this.chargingCurrent = Double.parseDouble(data.get(4));
        this.address = data.get(5);
        this.meterReading = Double.parseDouble(data.get(6));
    }
    // getters & setters
}