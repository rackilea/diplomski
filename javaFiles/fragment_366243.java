public class RequestBean implements Serializable {
    ...

    private Vector<String> driverInfo;
    private Vector<String> driverChanges;

    public Vector<String> getDrivers() throws Exception {
        ...
        setDriverInfo(doc.getItemValue("DriverInfo"));
        setDriverChanges(doc.getItemValue("DriverChanges"));
        return driverInfo;
    }

    public void setDriverInfo(Vector<String> driverInfo) {
        this.driverInfo = driverInfo;
    }

    public Vector<String> getDriverInfo() {
        return driverInfo;
    }

    public void setDriverChanges(Vector<String> driverChanges) {
        this.driverChanges = driverChanges;
    }

    public Vector<String> getDriverChanges() {
        return driverChanges;
    }

    public void save() throws Exception {
        ...
        doc.replaceItemValue("driverInfo", getDriverInfo());
        doc.replaceItemValue("driverChanges", getDriverChanges());
        doc.save();
    }
}