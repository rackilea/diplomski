buttonSubmitReport.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        reports.setDate(textDate.getText().toString().trim());
        reports.setTime(textTime.getText().toString().trim());
        reports.setReport(editRep.getText().toString().trim());

        reff.push().setValue(reports);

        reff.child(String.valueOf(maxID + 1)).setValue("Reports")
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Write was successful!, here either finish or move to another activity
                        Toast.makeText(submitReport.this, "Thanks for the information!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                        Toast.makeText(submitReport.this, "Failed to store the data", Toast.LENGTH_LONG).show();
                    }
                });
    });