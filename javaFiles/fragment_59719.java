final public class Util {
    private Util() {
        throw new AssertionError(); // there is not supposed to exist an instance
    }

    public static DataElem getData() {
        return  new Util.DataElem();
    }

    private static class DataElem {
        private DataElem(){} // keep private if you just want elements to be created via Factory method
        // class definition
    }
}