Map<String, Object> latLong = new HashMap<>();
latLong.put("latitude", "123");
latLong.put("longitude", "123");

dbRef.child("users").child(currentUserId).updateChildren(latLong).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
            Log.i("Info", "updateUser:success");
        } else {
            Log.i("Info", "updateUser:failure");
        }
            }
        });