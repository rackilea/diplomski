List<String> units =   Arrays.asList(getResources().getStringArray(R.array.units));
    Spinner spinner = (Spinner) findViewById(R.id.spinner_from);
    spinner.setAdapter(new TestAdapter(units , this);



public class TestAdapter extends BaseAdapter {

List<String> strings;
Context context;

public TestAdapter(List<String> stringList, Context context) {
    strings = stringList;
    this.context = context;
}


@Override
public int getCount() {
    return strings.size();
}

@Override
public String getItem(int position) {
    return strings.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    TextView textView = new TextView(context);

    textView.setText(strings.get(position));

    //here you can use position or string
    if(position == 1 || strings.get(position).equals("Cal")) {
        textView.setBackgroundColor(Color.RED);
    }

    return textView;
}