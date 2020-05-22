String[] data= {"Grid view","chart view"};
Spinner spinner = (Spinner) findViewById(R.id.spinner3);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,data);

spinner .setAdapter(adapter);
adapter.notifyDataSetChanged();