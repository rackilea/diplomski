package javax.swing;

import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.accessibility.Accessible;

public class JMButton extends AbstractButton implements Accessible {
    private static final String uiClassID = "JMButtonUI";

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        if (getUIClassID().equals(uiClassID)) {
            byte count = JComponent.getWriteObjCounter(this);
            JComponent.setWriteObjCounter(this, --count);
            if (count == 0 && ui != null) {
                ui.installUI(this);
            }
        }
    }

}