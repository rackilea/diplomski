@ManagedBean(name="BeanOne")
@RequestScoped
public class BeanOne {
    private Data data;

    public Data getBean(String title) {
        data = new Data(title);
        return data;
    }
    public void show() {
        System.out.println("User Input ==>" + data.getInput());
    }
}