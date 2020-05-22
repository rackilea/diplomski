public class Main {
    private String tempPath;

    public void insert(String path) {       
        this.tempPath = path;
        onListItemClick(null, null, 0, 0);
    }

    public void onListItemClick(Object l, Object v, int position, long id) { // just for show, should be your actual method
        System.out.println(tempPath); // do some null check, obviously
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.insert("Path to enlightenment.");
    }
}