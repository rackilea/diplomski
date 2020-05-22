public void commitData(){

    Bundle bundle = new Bundle();
    bundle.putString("key", txtBuildingName.getText().toString()); //Gets the TEXT that the TEXTVIEW was holding converts it to a String and adds to the Extras bundle
    bundle.putString("key1", txtDescription.getText().toString()); // Same again
    bundle.putString("key2", type.getItemAtPosition(type.getSelectedItemPosition()).toString());
    bundle.putString("key3", project.getItemAtPosition(project.getSelectedItemPosition()).toString());