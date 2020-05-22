public class CustomAdapter extends BaseAdapter {
    Main3Activity  main;
    private static final String TAG = CustomAdapter.class.getSimpleName();
    ArrayList<DataModel> listArray;

    public CustomAdapter(Main3Activity main) {
        this.main = main;
        listArray = new ArrayList<DataModel>(5);
        listArray.add(new DataModel("الفاتحه", 5, 1.8, "Java"));
        listArray.add(new DataModel("البقرة", 10, 2.8, "Python"));
        listArray.add(new DataModel("ال عمران", 15, 3.8, "Django"));
    }