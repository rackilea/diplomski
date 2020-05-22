import org.apache.catalina.valves.ValveBase;

public class MyValve extends ValveBase {

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        // ...

        getNext().invoke(request, response);
    }

}