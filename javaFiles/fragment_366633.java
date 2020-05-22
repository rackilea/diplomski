public class YourAction extends ActionSupport implements ServletContextAware {
  private ServletContext servletContext;

  @Override
  public String execute() throws Exception {
    String someValue = (String) servletContext.getAttribute("someSetting");

    return SUCCESS;
  }

  @Override
  public void setServletContext(final ServletContext context) {
    this.servletContext = servletContext;
  }
}