public class ObjectParcelableAdapter extends ArrayAdapter<ObjectParcelable> {
  public ObjectParcelableAdapter (Context context, ArrayList<ObjectParcelable> objects) {
    super(context, 0, objects);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // Get the data item for this position
    ObjectParcelable object = getItem(position);    

    // Check if an existing view is being reused, otherwise inflate the view
    if (convertView == null) {
      convertView =LayoutInflater.from(getContext()).inflate(R.items_for _second_listview, parent, false);
    }

    // set your textviews values here
    return convertView;
  }
}