import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;


@Named("rolesConverter")
@RequestScoped
public class RolesConverter implements Converter, Serializable {

@EJB
private RoleFacade roleFacade;

@Override
public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Roles role = null;
        if ((value != null) && (!value.equals(""))) {       
             role = roleFacade.find(Long.valueOf(value));       
        }
        return role;
}

@Override
public String getAsString(FacesContext context, UIComponent component, Object value) {
        Integer retorno = null;
        if (!(value == null)) {
            Roles role = new Roles();
            role = (Roles) value;
            retorno = role.getId();
        }
        return retorno.toString();
}