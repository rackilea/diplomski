public class MyListModel extends AbstractListModel<AppListItem> {

    ArrayList<AppListItem> list=new ArrayList<>();

    public void selectAllApps() {
        for(AppListItem i:list) i.setSelected(true);
        fireContentsChanged(this, 0, getSize()-1);
    }

    public int getSize() {
      return list.size();
    }

    public AppListItem getElementAt(int index) {
      return list.get(index);
    }

    // if you need such updates:
    public void add(int index, AppListItem item) {
      list.add(index, item);
      fireIntervalAdded(this, index, index);
    }

    public boolean remove(AppListItem i) {
      int index = list.indexOf(i);
      if(index<0) return false;
      remove(index);
      return true;
    }

    public void remove(int index) {
      list.remove(index);
      fireIntervalRemoved(this, index, index);
    }
}