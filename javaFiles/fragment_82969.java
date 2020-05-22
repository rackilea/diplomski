protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
    if (result != null) {
        //if qrcode has nothing in it
        if (result.getContents() == null) {
            Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
        } else {
            //if qr contains data
            try {
                //converting the data to vCard object
                VCard vcard = Ezvcard.parse(result.getContents()).first();
                //setting values to textviews

                // "given name" is the first name
                etFirstName.setText(vcard.getStructuredName().getGiven());

                // "family name" is the last name
                etLastName.setText(vcard.getStructuredName().getFamily());
                ...