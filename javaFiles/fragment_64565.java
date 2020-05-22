@ViewScoped
@ManagedBean
public class OnErrorBean {

    private String test;

    public void onPreRenderView() {
        if (FacesContext.getCurrentInstance().isValidationFailed()) {
            onError();
        }
    }

    public void onSuccess() {
        System.out.println("Success!");
    }

    public void onError() {
        System.out.println("Error!");
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

}