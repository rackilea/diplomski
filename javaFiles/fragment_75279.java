public class Controller extends SelectorComposer<Window> {

 private static final EventListener<Event> EVENT_STOPPER = new EventListener<Event>() {
   public void onEvent(Event event) throws Exception {
        event.stopPropagation();
        System.out.println("Stopped propagation of " + event);
   }
 };

 @Wire
 private Tabbox mainTab;

 @Override
 public void doAfterCompose(Window comp) throws Exception {
   super.doAfterCompose(comp);
   addCloseEventStopper();
 }

 @Listen(Events.ON_CLICK + " = #addTabsButton")
 public void addTabsButtonClicked() {
   removeCloseEventStopper();
   addTabs();
 }

 private void addCloseEventStopper() {
   mainTab.getSelectedTab().addEventListener(Events.ON_CLOSE, EVENT_STOPPER);
 }

 private void removeCloseEventStopper() {
   mainTab.getSelectedTab().removeEventListener(Events.ON_CLOSE, EVENT_STOPPER);
 }

 private void addTabs() {
   Tabs tabs = mainTab.getTabs();
   tabs.appendChild(new Tab("Tab Two"));
   tabs.appendChild(new Tab("Tab Three"));
 }

}