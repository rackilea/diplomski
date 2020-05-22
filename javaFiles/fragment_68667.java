@Named
@ViewScoped
public class SampleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Person> dataSample;

    @PostConstruct
    private void init() {
        dataSample = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            dataSample.add(person);
        }
    }

    public void process() {
        dataSample.forEach(System.out::println);
    }

    public List<Person> getDataSample() {
        return dataSample;
    }
}