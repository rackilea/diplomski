/* Struts Action class with execute method */
public class HelloWorldAction implements Action
{
    private String greeting;

    /* Uses indirection for DAO construction */
    @Override
    public String execute() throws Exception {
        HelloWorldDAO dao = newHelloWorldDAO();
        setGreeting(dao.findGreeting());
        return SUCCESS;
    }

    /* The simplest possible dependency injection */
    protected HelloWorldDAO newHelloWorldDAO() {
        return new HelloWorldDAO();
    }

    public String getGreeting() {
        return this.greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}