public class MyDataClass {

    private final int value ;

    private final long generationTime ;

    public MyDataClass(int value) {
        this.value = value ;
        this.generationTime = System.nanoTime() ;
    }

    public int getValue() {
        return value ;
    }

    public long age() {
        return System.nanoTime() - generationTime ;
    }
}