public class MainActivity extends Activity implements OnItemSelectedListener {
private List<Driver> drivers;
private Spinner spinner;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    spinner = (Spinner) findViewById(R.id.spinner);
    spinner.setOnItemSelectedListener(this);

    new DBTask().execute();
}

class DBTask extends AsyncTask<Void, Void, List<Driver>> {

    @Override
    protected List<Driver> doInBackground(Void... params) {
        DataBaseHelper dbHelper = new DataBaseHelper(MainActivity.this);
        return dbHelper.queryAllDriver();
    }

    @Override
    protected void onPostExecute(List<Driver> result) {
        bindSpinner(result);
    }
}

private void bindSpinner(List<Driver> drivers) {
    this.drivers = drivers != null ? drivers : new ArrayList<DataBaseHelper.Driver>(0);

    ArrayAdapter<Driver> adapter = new ArrayAdapter<DataBaseHelper.Driver>(this,
            android.R.layout.simple_spinner_item, this.drivers);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
}

@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    if (this.spinner != null && position >= 0 && position < this.drivers.size()) {
        Driver driver = drivers.get(position);
        Toast.makeText(this, "selected: driver=" + driver.name + ", code=" + driver.code,
                Toast.LENGTH_SHORT).show();
    }
}

@Override
public void onNothingSelected(AdapterView<?> parent) {
    Toast.makeText(this, "nothing selected", Toast.LENGTH_SHORT).show();
}