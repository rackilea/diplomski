HashMap<String, String> examCodesMap = new HashMap<String, String>();
Spinner spinner = (Spinner) findViewById(R.id.spinner);
ArrayList<String> arrayList = new ArrayList<>();

for(Map.Entry<String, HashMap> entry : selects.entrySet()) {
    String key = entry.getKey();
    String value = entry.getValue();

    arrayList.add(value);
}

ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.spinner, arrayList);