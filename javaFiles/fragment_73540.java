import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class FilterableListModel<E> extends AbstractListModel<E> implements ListDataListener {

    private ListModel<E> peer;
    private List<Integer> lstFilteredIndicies;
    private IFilterable filter;

    public FilterableListModel() {
        lstFilteredIndicies = new ArrayList<Integer>(25);
    }

    public FilterableListModel(ListModel<E> model) {
        this();
        setModel(model);
    }

    public FilterableListModel(ListModel<E> model, IFilterable filter) {
        this();

        setModel(model);
        setFilter(filter);
    }

    public void setModel(ListModel<E> parent) {
        if (peer == null || !peer.equals(parent)) {
            if (peer != null) {
                fireIntervalRemoved(this, 0, peer.getSize() - 1);
                peer.removeListDataListener(this);
            }

            peer = parent;
            lstFilteredIndicies.clear();
            if (peer != null) {
                peer.addListDataListener(this);
            }
            filterModel(true);
        }
    }

    public ListModel<E> getModel() {
        return peer;
    }

    @Override
    public int getSize() {
        IFilterable filter = getFilter();
        return filter == null ? getModel() == null ? 0 : getModel().getSize() : lstFilteredIndicies.size();
    }

    @Override
    public E getElementAt(int index) {
        IFilterable filter = getFilter();
        ListModel<E> model = getModel();

        E value = null;
        if (filter == null) {
            if (model != null) {
                value = model.getElementAt(index);
            }
        } else {
            int filterIndex = lstFilteredIndicies.get(index);
            value = model.getElementAt(filterIndex);
        }
        return value;
    }

    public int indexOf(Object value) {
        int index = -1;
        for (int loop = 0; loop < getSize(); loop++) {
            Object at = getElementAt(loop);
            if (at == value) {
                index = loop;
                break;
            }
        }
        return index;
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        IFilterable filter = getFilter();
        ListModel model = getModel();

        if (model != null) {
            if (filter != null) {
                int startIndex = Math.min(e.getIndex0(), e.getIndex1());
                int endIndex = Math.max(e.getIndex0(), e.getIndex1());
                for (int index = startIndex; index <= endIndex; index++) {
                    Object value = model.getElementAt(index);
                    if (filter.include(value)) {
                        lstFilteredIndicies.add(index);
                        int modelIndex = lstFilteredIndicies.indexOf(index);
                        fireIntervalAdded(this, modelIndex, modelIndex);
                    }
                }
            } else {
                fireIntervalAdded(this, e.getIndex0(), e.getIndex1());
            }
        }
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        IFilterable filter = getFilter();
        ListModel model = getModel();

        if (model != null) {
            if (filter != null) {
                int oldRange = lstFilteredIndicies.size();
                filterModel(false);
                fireIntervalRemoved(this, 0, oldRange);
                if (lstFilteredIndicies.size() > 0) {
                    fireIntervalAdded(this, 0, lstFilteredIndicies.size());
                }
            } else {
                fireIntervalRemoved(this, e.getIndex0(), e.getIndex1());
            }
        }
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        filterModel(true);
    }

    public void setFilter(IFilterable<E> value) {
        if (filter == null || !filter.equals(value)) {
            filter = value;
            if (getModel() != null) {
                if (getModel().getSize() > 0) {
                    fireIntervalRemoved(this, 0, getModel().getSize() - 1);
                }
            }
            filterModel(true);
        }
    }

    public IFilterable<E> getFilter() {
        return filter;
    }

    protected void filterModel(boolean fireEvent) {
        if (getSize() > 0 && fireEvent) {
            fireIntervalRemoved(this, 0, getSize() - 1);
        }
        lstFilteredIndicies.clear();

        IFilterable<E> filter = getFilter();
        ListModel<E> model = getModel();
        if (filter != null && model != null) {
            for (int index = 0; index < model.getSize(); index++) {
                E value = model.getElementAt(index);
                if (filter.include(value)) {
                    lstFilteredIndicies.add(index);
                    if (fireEvent) {
                        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
                    }
                }
            }
        }
    }

    public void updateFilter() {
        IFilterable filter = getFilter();
        ListModel model = getModel();

        if (filter != null && model != null) {
            for (int index = 0; index < model.getSize(); index++) {
                Object value = model.getElementAt(index);
                if (filter.include(value)) {
                    if (!lstFilteredIndicies.contains(index)) {
                        lstFilteredIndicies.add(index);
                        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
                    }
                } else if (lstFilteredIndicies.contains(index)) {
                    int oldIndex = lstFilteredIndicies.indexOf(index);
                    lstFilteredIndicies.remove(oldIndex);
                    fireIntervalRemoved(this, oldIndex, oldIndex);
                }
            }
        }
    }
}