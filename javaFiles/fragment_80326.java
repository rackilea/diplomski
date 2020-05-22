public class CustomTable extends JTable {

    // No more scroll pane; only observers
    private List<ChangeListener> listeners = [];

    // no more scroll pagne
    public CustomTable(){
        super();
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
        this.fireChangeEvent();
    }

    /* new methods */

    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        // ...
    }

    private void fireChangeEvent() {
        for(String l : listeners ){
            l.onChange();
        }
    }
}