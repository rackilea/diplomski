public class SingletonArrayList {
    private static SingletonArrayList mInstance;
    private static ArrayList<String> list = null;

    public static SingletonArrayList getInstance() {
        if (mInstance == null) {
            mInstance = new SingletonArrayList();
            SingletonArrayList.list.add("a");
            SingletonArrayList.list.add("b");
            SingletonArrayList.list.add("c");
        }

        return mInstance;
    }

    private SingletonArrayList() {
        list = new ArrayList<String>();
    }

    // retrieve array from anywhere
    public ArrayList<String> getArray() {
        return SingletonArrayList.list;
    }

}