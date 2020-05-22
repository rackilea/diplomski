case R.id.nav_add_venue:
    if(dialog == null) {
        LayoutInflater inflater = this.getLayoutInflater(); 
        View addVenueDialog = inflater.inflate(R.layout.add_venue_dialog, null); 

        builder.setView(addVenueDialog); 

        final EditText vName = (EditText) addVenueDialog.findViewById(R.id.vName); 
        final EditText vAddress = (EditText) addVenueDialog.findViewById(R.id.vAddress); 

        // Other code //
        dialog = builder.create();
     }
     dialog.show();
     break;