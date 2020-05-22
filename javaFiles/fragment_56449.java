/** Request scope bean defined in faces-config.xml */
public class ComponentMakerBean {
  private UIPanel panel;

  public UIPanel getPanel() {
    if(panel == null) {
      panel = new HtmlPanelGroup();
      for(int i=0; i<3; i++) {
        panel.getChildren().add(new HtmlInputText());
      }
    }
    return panel;
  }

  public void setPanel(UIPanel panel) { this.panel = panel; }

  public String dumpValuesAction() {
    for(Object kid : panel.getChildren()) {
      if(kid instanceof ValueHolder) {
        ValueHolder valueHolder = (ValueHolder) kid;
        System.out.println(valueHolder.getValue());
      }
    }
    return null; //no navigation
  }
}