array_spinner = new String[sitesList.getName().size()];
for (int i = 0; i < sitesList.getName().size(); i++)
{
    name = sitesList.getName().get(i);
    array_spinner[i] = name;
    Log.i("array_spinner" + i, array_spinner[i]);
}
Spinner s = (Spinner) findViewById(R.id.Spinner01);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
    android.R.layout.simple_spinner_item, array_spinner);
s.setAdapter(adapter);