@Component
@Scope("prototype")
public class SupportBean {

    private String actualPath;

    public void setActualPath(String actualPath) {
        this.actualPath = actualPath
    }
}