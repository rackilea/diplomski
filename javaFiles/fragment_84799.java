FirebaseMarker firebaseMarker = new FirebaseMarker(
    studioNameTextField.getText().toString(),
    studioInfoTextField.getText().toString(),
    studioAdressTextField.getText().toString(),
    53.669115, 12.560311);
mDataBaseRef.push().setValue(firebaseMarker);