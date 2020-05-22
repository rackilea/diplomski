// Listen for layout click events
layout.addListener(new LayoutClickListener() {
 public void layoutClick(LayoutClickEvent event) {

     // Get the child component which was clicked
     Component child = event.getChildComponent();

     if (child == null) {
         // Not over any child component
         getWindow().showNotification(
                 "The click was not over any component.");
     } else {
         // Over a child component
         getWindow().showNotification(
                 "The click was over a "
                         + child.getClass().getCanonicalName());
     }
 }
});