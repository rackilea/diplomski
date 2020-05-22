public class TestTag extends TagSupport {
protected String id;
static int count = 0;
int instanceNuber=0;

public TestTag() {
    super();
    System.out.println("TestTag.TestTag() - new Instance");
    instanceNuber = ++count;
}

@Override
public int doStartTag() throws JspException {
    JspWriter out = pageContext.getOut();
    try {
        out.print("id = " + getIdWrapper());
    } catch (IOException e) {
    }
    return (SKIP_BODY);
}

public String getIdWrapper() {
    return getId();
}

@Override
public String getId() {
    System.out.println("Instance " + instanceNuber + " of TestTag.getId() = " + id);
    return id;
}

@Override
public void setId(String id) {
    System.out.println("Instance " + instanceNuber + " of TestTag.setId(" + id + ")");
    this.id = id;
}
}