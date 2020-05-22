@ManagedBean
@ViewScoped
public class DatatableBean {

    private List<Data> lstData;
    /**
    * Creates a new instance of datatableBean
    */
    public DatatableBean() {
        lstData = new ArrayList<Data>();
        lstData.add(new Data(1, "Hello World"));
        lstData.add(new Data(2, "Hello StackOverflow"));
        lstData.add(new Data(3, "Hello Luiggi"));
        System.out.println("LOL");
    }
    //define getters and setters...
}