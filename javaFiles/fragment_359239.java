package com.mbpe.search;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JInternalFrame;
import javax.swing.JInternalFrame;
import com.mbpe.gui.Portada;
import com.mbpe.main.Main;
import com.mbpe.main.searchEvent;
import com.mbpe.main.searchEventListener;



@SuppressWarnings("serial")
public class searchForm extends JInternalFrame {
public searchForm(String title, boolean resizable, boolean closable,
        boolean maximizable, boolean iconifiable) {
    super(title, resizable, closable, maximizable, iconifiable);
}

private List _listeners = new ArrayList();
public synchronized void addSearchEventListener(searchEventListener listener) {
    _listeners.add(listener);
}
public synchronized void removeSearchEventListener(searchEventListener listener) {
    _listeners.remove(listener);
}
public synchronized void fireEvent() {
    searchEvent event = new searchEvent(this);
    Iterator i = _listeners.iterator();
    while (i.hasNext()) {
        ((searchEventListener) i.next()).resultFound(event);
    }
}

public void onClose() {

}

public void onClosing() {
    dispose();
}