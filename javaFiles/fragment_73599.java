public class ViewLoader
{
    private    String      fxmlStr         = "(none)";
    private    Parent      rootNode        = null;
    private    CellView    viewController  = null;


    public  void loadView( final String urlStr ){

        Parent      root        = null;
        URL         fxmlResource;
        FXMLLoader  fxmlLoader  = null;
        try
        {
            fxmlResource = getClass().getResource( urlStr );
            fxmlLoader = new FXMLLoader( fxmlResource, Resources.getResourceBundle() );

            root = fxmlLoader.load( );

            this.viewController = fxmlLoader.getController();
            this.fxmlStr        = urlStr;
            this.rootNode       = root;
        }
        catch (Exception ex)
        {
            puts( "  * Exception on FXMLLoader.load()");
            puts( "  * "+ex.getMessage());
            puts( "    ----------------------------------------\n");
        }
    }


    public  CellView    getView(){

        return this.viewController;
    }

    public  ViewLoader( final String urlStr ){

        loadView( urlStr );
    }

}//ViewLoader class