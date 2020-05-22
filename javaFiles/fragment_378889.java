@ManagedBean
@ViewScoped
public class Bean implements Serializable {

    private List<Tab> tabs;

    @PostConstruct
    public void init() {
        // Just a stub. Do your thing to populate tabs.
        // Make sure that the last tab is the "Add" tab.
        tabs = new ArrayList<Tab>();
        tabs.add(new Tab("tab1", "content1"));
        tabs.add(new Tab("tab2", "content2"));
        tabs.add(new Tab("Add...", null));
    }

    public void changeTab(TabChangeEvent event) {
        int currentTabIndex = ((TabView) event.getComponent()).getActiveIndex();
        int lastTabIndex = tabs.size() - 1; // The "Add" tab.

        if (currentTabIndex == lastTabIndex) {
            tabs.add(lastTabIndex, new Tab("tab" + tabs.size(), "content" + tabs.size())); // Just a stub. Do your thing to add a new tab.
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.update("form:tabs"); // Update the p:tabView to show new tab.
            requestContext.addCallbackParam("newTabIndex", lastTabIndex); // Triggers the oncomplete.
        }
    }

    public List<Tab> getTabs() {
        return tabs;
    }

}