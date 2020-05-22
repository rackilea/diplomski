abstract class BasicField {
    public String sharedData1;
    public double sharedData2;
}

class DisplayField extends BasicField {
    private int data;

    public void saveData() {
        // save parent's data every time in every subclass!! Not fun!
        // save DisplayField's private data
    }
}