public class NonStaticClass {

    private Integer lastUse = new Integer(0);

    public Integer getLastUse() {
        return lastUse++;
    }
}