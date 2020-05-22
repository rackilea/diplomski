@ManagedBean(name="testBean")
@SessionScoped
public class testBean implements Serializable { 

   @ManagedProperty(value="#{configBean}")
   private ConfigBean configBean;

   ....

   ... configBean.getVariableName().isCached()...
}