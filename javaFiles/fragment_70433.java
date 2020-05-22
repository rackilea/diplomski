abstract class BasicField {
    public String sharedData1;
    public double sharedData2;

    public void saveData() {
        // save sharedData1
        // save sharedData2
    }
}

class DisplayField extends BasicField {
    private int data;

    public void saveData() {
        super.saveData();
        // save DisplayField's private data
    }
}