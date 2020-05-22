private ProgressDialog dialog;
private ArrayList<NoteItem> nItems

public void uploadNotesToSTORAGE(final ArrayList<NoteItem> items, Activity activity) {
    nItems = items

    dialog = new ProgressDialog(activity);
    dialog.setMessage("Uploading picture...");
    dialog.show();


    if(nItems != null && !nItems.isEmpty()){
      uploadSingleNote(nItems.get(0));        //get first item
     }
}

private void uploadSingleNote(NoteItem item){
    final String id = Calendar.getInstance().getTimeInMillis() + "";
    StorageReference reference = mStorageRef.child("notes/" + id);
    String filePath = item.getFilePath();

    reference.putFile(Uri.fromFile(new File(filePath))).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
        @Override
        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            StorageReference reference = mStorageRef.child("notes/" + id);
            reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri dUri) {
                    item.setId(id);
                    item.setDownloadLink(dUri + "");
                    db.collection("notes").document().set(nItems.get(finalI))
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(activity, "Successfully uploaded : " + item.getFileName(), Toast.LENGTH_SHORT).show();
                            nItems.remove(0);
                            if(nItems != null && !nItems.isEmpty()){
                               uploadSingleNote(nItems.get(0));        //get first item
                             }else{
                              dialog.dismiss();
                                activity.finish();
                              activity.startActivity(new Intent(activity, MainActivity.class));
                             }
                          }
                     });
                }
            });
        }
    }).addOnFailureListener(onFailureListener);
}