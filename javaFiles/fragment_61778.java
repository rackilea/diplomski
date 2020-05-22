public interface AnInterface {
    public getText(); // Abstract method (re)definition

    default String getStringValue() {
        return this.getText();
    }
}