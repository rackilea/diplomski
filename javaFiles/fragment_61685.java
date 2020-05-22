public class Lwm extends ListActivity {
  private TextView mSelection;
  private List<MonitorObject> mMonitorObjects;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mMonitorObjects = getMonitorObjects();
    setContentView(R.layout.main);
    setListAdapter(new CustomAdapter());
    mSelection = (TextView)findViewById(R.id.selection);
  }

  @Override
  public void onListItemClick(ListView parent, View v, int position, long id){
    mSelection.setText("Selection length is: " + mMonitorObjects.get(position).toString().length());
  }

  private class CustomAdapter extends ArrayAdapter<MonitorObject> {
    CustomAdapter() {
      super(Lwm.this, R.layout.row, R.id.label, mMonitorObjects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {     
      View row = convertView;

      if (row == null) {
        // This gives us a View object back which, in reality, is our LinearLayout with 
        // an ImageView and a TextView, just as R.layout.row specifies.
        LayoutInflater inflater = getLayoutInflater();      
        row = inflater.inflate(R.layout.row, parent, false);
      }

      TextView label = (TextView) row.findViewById(R.id.label);
      label.setText(mMonitorObjects.get(position).toString());
      ImageView icon = (ImageView)row.findViewById(R.id.icon);

      MonitorObject mo = getMonitorObjects().get(position);

      if (mo.ismAlarm()) {
        icon.setImageResource(R.drawable.alarm);
        row.setBackgroundColor(Color.RED);
      } else if (mo.ismWarning()){
        icon.setImageResource(R.drawable.warning);
        row.setBackgroundColor(Color.YELLOW);
      } else {
        icon.setImageResource(R.drawable.ok);
        row.setBackgroundColor(Color.GREEN);
      }

      return row;       
    }
  }

  private List<MonitorObject> getMonitorObjects() {
    List<MonitorObject> mos = new ArrayList<MonitorObject>();
    mos.add(new MonitorObject(15000, 20000, 25000));
    mos.add(new MonitorObject(15000, 14000, 18000));
    mos.add(new MonitorObject(15000, 12000, 14000));
    mos.add(new MonitorObject(100, 200, 250));
    mos.add(new MonitorObject(3000, 2500, 3500));
    return mos;
  }
}