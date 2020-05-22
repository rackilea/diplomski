public class ABPortlet extends MVCPortlet 
{
  private String userName;
  @EJB(beanName = "portletControllerBean")
  PortletControllerBean controller;

  public ABPortlet() {}

  public void doView(RenderRequest rr, RenderResponse rp) throws IOException,PortletException 
  {
    userName = controller.getUserName();
    if(userName==null) {
      userName = "nope";
    }
    rr.setAttribute("userName", userName);
    super.doView(rr, rp);
  }
}