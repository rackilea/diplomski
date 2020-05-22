private void storeDataToFirebase() {

    String id = databaseAdvertisement.push().getKey();
    Advertisement advertisement = new Advertisement(id, downloadURL, tuitioname, providername, providergender, tuitionaddress, tuitionyear, tuitioncontactnumber, tuitionemail, tuitionsubject, tuitionprice, tuitionclasssize);

    databaseAdvertisement.child(id).setValue(advertisement)
            .addOnSuccessListener(new OnSuccessListener<Void>()
            {
                @Override
                public void onSuccess(Void aVoid)
                {
                    Toast.makeText(AddAdsActivity.this, "Advertisement added successfully!", Toast.LENGTH_SHORT).show();

                    Intent ViewAdsIntent = new Intent(AddAdsActivity.this, ViewAdsActivity.class);
                    ViewAdsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(ViewAdsIntent);
                    finish();

                    loadingBar.dismiss();
                }
            })
            .addOnFailureListener(new OnFailureListener()
            {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    Toast.makeText(AddAdsActivity.this, "Failed to save the advertisement data. Please try again.", Toast.LENGTH_LONG).show();
                    loadingBar.dismiss();
                }
            });

}