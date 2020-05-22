FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReferenceFromUrl("gs://myfirebaseproject.appspot.com");
            StorageReference fileRef =
                    storageRef.child(channelId)
                    .child(String.valueOf(message.getSender()))
                    .child(String.valueOf(message.getTimestamp()));

            UploadTask uploadTask = fileRef.putFile(message.getAttachmentUri());
            uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    sendMessage(channelId, message.getMessageText(), taskSnapshot.getStorage().toString(), message.getAttachmentType(), callback);
                }
            });
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    callback.onError(e.toString());
                }
            });