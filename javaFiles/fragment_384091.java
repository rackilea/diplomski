public class PublisherComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private List<Publisher> publishers;
    private Publisher selectedItem;

    public PublisherComboBoxModel(List<Publisher> publishers) {
        this.publishers = new ArrayList<>(publishers);
    }

    public void addPublisher(Publisher pub) {

        publishers.add(pub);
        fireIntervalAdded(this, publishers.size() - 1, publishers.size() - 1);

    }

    @Override
    public int getSize() {            
        return publishers.size();            
    }

    @Override
    public Object getElementAt(int index) {            
        return publishers.get(index);        
    }

    @Override
    public void setSelectedItem(Object anItem) {            
        selectedItem = (Publisher) anItem;            
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}