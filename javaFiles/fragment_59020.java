import javax.faces.context.FacesContext;
// import com.ibm.designer.runtime.domino.adapter.servlet.LCDAdapterHttpSession;
import javax.servlet.http.HttpSession;
...
...
// LCDAdapterHttpSession s = (LCDAdapterHttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
HttpSession s = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
return s.getId();