public class CreateAction extends ActionSupport
{

    private String actionUrl;

    public String getActionUrl() {
        return actionUrl;
    }

    @Override
    public String execute() throws Exception
    {
            String actionPath = "/view";
            String createType = req.getParameter("createType");
            String params = "&action=view";
            if("1".equals(createType)){
               params = params + "&from=list";
            }else if("2".equals(createType)){
               params = params + "&from=detail&someParam=someValue";
            }//,etc..
            actionUrl = actionPath+"?"+params;
            return SUCCESS;
    }
}