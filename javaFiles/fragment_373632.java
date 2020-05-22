String DESTINATION_LOCATION = "My location name";
    String latit = "37.925942";
    String longit = "23.938683";
    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
    Uri.parse("geo:<"+latit+">,<"+longit+">?q=<"+latit+">,<"+longit+">("+DESTINATION_LOCATION+")")); //name the label
    startActivity(intent);