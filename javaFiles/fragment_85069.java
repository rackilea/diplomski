public class DGCSDefiner extends GridPane {
    private final DGCSDefinerController Controller;
    public DGCSDefiner(){
        this.Controller = this.Load();
    }

    private DGCSDefinerController Load(){
        final FXMLLoader loader = new FXMLLoader();
        loader.setRoot(this);
        loader.setClassLoader(this.getClass().getClassLoader());
        loader.setLocation(this.getClass().getResource("DGCSDefiner.fxml"));

        try{
            final Object root = loader.load();
            assert root == this;
        } catch(IOException ex){
            throw new IllegalStateException(ex);
        }

        final DGCSDefinerController cntrlr = loader.getController();
        assert cntrlr != null;
        return cntrlr;
    }

    /**
     * Get the settings defined by the controller.
     * @return controller defined settings.
     */
    public ColorSettings getColorSettings(){
        return this.Controller.getColorSettings();
    }

    /**
     * Set the controllers color settings.
     * @param CS Defined color settings.
     */
    public void setColorSettings(ColorSettings CS){
        this.Controller.setColorSettings(CS);
    }
}