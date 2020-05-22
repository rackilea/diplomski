List<MarkerOptions> busesList = new ArrayList<>();
 List<MarkerOptions> tarinsList = new ArrayList<>();
    public void addMarker2Map() {

        busesList.add(mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_gps_fixed_black_24dp)).snippet("an hour interval for Sydney")));
        //add others like this

        tarinsList.add(mMap.addMarker(new MarkerOptions().position(albany).title("Marker in Albany").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_gps_fixed_black_24dp)).snippet("an hour interval for Albany")));
        //add others like this

    }

//UPDATED 

AlertDialog dialog;
CheckBox buses, trains;

public void filterTheMarkers(View view) {
    if (dialog == null) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View checkBoxView = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(checkBoxView);
        buses = (CheckBox) checkBoxView.findViewById(R.id.checkBox1);
        trains = (CheckBox) checkBoxView.findViewById(R.id.checkBox2);
        //Button okButton = (Button) checkBoxView.findViewById(R.id.okButton);
        //Button cancelButton = (Button) checkBoxView.findViewById(R.id.cancelButton);
        dialog = builder.create();
    }
    dialog.show();
}

public void displaySelectedMarkers(View view) {
    dialog.dismiss();
    Log.i("TAG", "Trains Status " + trains.isChecked() + " Bus Status  " + buses.isChecked());
    //according these check boxes status execute your code to show/hide markers
    for(MarkerOptions train : trainsList){
        train.visible(trains.isChecked());
    }
    for(MarkerOptions buss : busesList){
        buss.visible(buses.isChecked());
    }
}

public void doNothing(View view) { dialog.dismiss(); }