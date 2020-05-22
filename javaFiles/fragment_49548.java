public class SymptomsListAdapter extends BaseAdapter implements ListAdapter {
  ...
  public void refreshData(ArrayList<Symptoms> objects){
    this.listState = (ArrayList<Symptoms>) objects;
    notifyDataSetChanged();
  }
  ...
}