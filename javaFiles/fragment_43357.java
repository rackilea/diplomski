@Named
@SessionScoped
public class QuestBean implements Serializable {

    @EJB
    protected QuestFacadeLocal questFacade; // possible because of local view
    @EJB
    protected QuestFacade questFacadeN; // possible because of no-interface view

    // several methods delegating lookups to the questFacade ...
}