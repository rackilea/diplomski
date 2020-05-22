public abstract class BaseTest {

    @Rule
    public MyBaseTestRule myProjectTestRule = new MyBaseTestRule(data());

    protected abstract List<Object[]> extraParams();

    public List<Object[]> data() {  
        List<Object[]> listTotal = new ArrayList<>();
        listTotal.addAll(extraParams());
        //add your base test data here
        return listTotal;
    }

    public abstract List<Object[]> extraParams();
}