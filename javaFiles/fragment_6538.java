@ManagedBean
@RequestScoped
public class Bean {

    private String lastName; // +getter+setter

    public void first() {
        // Invoke original FirstServlet's job here.
    }

    public void second() {
        // Invoke original SecondServlet's job here.
    }

}