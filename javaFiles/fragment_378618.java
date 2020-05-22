import Main.test;
import com.vaadin.ui.Accordion;

public class Accordiontest extends Accordion {
    public Accordiontest() {
        super();
        for (int i = 0; i < 5; i++) {
            TextField textfield = new TextField("some text field");
            addTab(textfield, "Tab" + (i+1), null);
         }
      } 
   }