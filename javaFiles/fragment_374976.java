@ManagedBean
@RequestScoped
public class CategoryConverter implements Converter {

    @EJB
    private CategoryService categoryService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Category) || ((Category) value).getId() == null) {
            return null;
        }

        return String.valueOf(((Category) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+")) {
            return null;
        }

        return categoryService.find(Long.valueOf(value));
    }

}