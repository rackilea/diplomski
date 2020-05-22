@Named
@SessionScope
public class IncludeBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private String includePage;

  @PostConstruct
  public void init() {
    includePage = "tmp/newxhtml.xhtml";
  }

  public String getIncludePage() {
    return includePage;
  }

  public void setIncludePage(String includePage) {
    this.includePage = includePage;
  }

}