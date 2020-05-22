@ManagedBean
@RequestScoped
public class AccessibilityMB {
    private boolean accessibilityOn = false;

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
        if(session!=null) {
            Boolean accessibilityMode = (Boolean)session.getAttribute("AccessibilityMode");
            accessibilityOn = accessibilityMode!=null && accessibilityMode;
        }
    }

    public String turnAccessibilityOff() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
        if(session!=null) {
            session.setAttribute("AccessibilityMode", accessibilityOn = true);
        }
        String viewId = context.getViewRoot().getViewId();
        return viewId+"?faces-redirect=true";
    }

    public String turnAccessibilityOn() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
        if(session!=null) {
            accessibilityOn = false;
            session.removeAttribute("AccessibilityMode");
        }
        String viewId = context.getViewRoot().getViewId();
        int index = viewId.lastIndexOf("/ac/");
        if(index>-1)
            viewId = viewId.substring(0, index)+viewId.substring(index+3);
        return viewId+"?faces-redirect=true";
    }

    public boolean getAccessibilityOn() {
        return accessibilityOn;
    }
}