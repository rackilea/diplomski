@Named
@SessionScoped
public class QuestBean implements Serializable {

    @EJB
    protected QuestFacadeLocal questFacade;

    // several methods delegating lookups to the questFacade ...
}