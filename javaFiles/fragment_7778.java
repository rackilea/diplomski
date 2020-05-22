public class ApplicationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_NAME = "appBean";

    private String name;
    private boolean godMode;

    public void setName(String name) {
        this.name = name;
    }

    public void setGodMode(boolean godMode) {
        this.godMode = godMode;
    }

    public boolean isGodMode() {
        return godMode;
    }

    // Your other logic here

    public static ApplicationBean getInstance(FacesContext facesContext) {
        return (ApplicationBean) Helper.resolveVariable(facesContext, name != null ? name : DEFAULT_NAME);
    }

}