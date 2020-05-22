public class BaseClass implements Comparable<BaseClass> {
    @Override
    public int compareTo(BaseClass o) {
        // implement this properly
        return 0;
    }
}

public class MyClass extends BaseClass {
    private String attr1;
    private Date attr2;
    private ChildClass attr3;

    //getter and setter
}

public class ChildClass extends BaseClass
{
    private String attr1;
    private Date attr2;
    private int attr3;

    //getter and setter
}

private List<MyClass> list;
private Map<String, Comparator<? super MyClass>> sortingOptions = new HashMap<>();
private String sortBy;  //sorting attribute selected by user

@PostConstruct
public void init()
{
    //my list to be sort
    list = myService.getList();

    sortingOptions.put("attr1", Comparator.comparing(MyClass::getAttr1));
    sortingOptions.put("attr2", Comparator.comparing(MyClass::getAttr2));
    sortingOptions.put("attr3", Comparator.comparing(MyClass::getAttr3));
    //......
}

public void sortOptionChangedListener()
{
    list.sort(sortingOptions.get(sortBy));
}