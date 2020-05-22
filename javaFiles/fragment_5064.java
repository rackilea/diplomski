public abstract class ParentServlet extends HttpServlet
{
    public Category[] getCategoryList() throws Exception
    {
         /**
          * Your getCategoryList codes
          */
    }
}

class ChildServelt_1 extends ParentServlet
{
    @Override
    public void service(ServletRequest arg0,
                        ServletResponse arg1) throws ServletException, IOException
    {
        /*
         * Do write your business
         */
        super.getCategoryList();
    }
}
class ChildServelt_2 extends ParentServlet
{
    @Override
    public void service(ServletRequest arg0,
                        ServletResponse arg1) throws ServletException, IOException
    {
        /*
         * Do write your business
         */
        super.getCategoryList();
    }
}