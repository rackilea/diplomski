String spinnerValue;

public void onCreate(...){
...
spinnerValue = cilj.getSelectedItem().toString()
...
}

public void onItemSelected(...){
     spinnerValue = cilj.getSelectedItem().toString();
}


Intent intent = new Intent(THIS_ACTIVITY,OTHER_ACTIVITY.CLASS);
intent.putExtra("spinnerValue",spinnerValue);
startActivity...