@Component
@WebFilter(urlPatterns = "/*")
public class MyWicketFilter extends WicketFilter {

    public MyWicketFilter() {
        super(new MyWicketApplication());
    }

}