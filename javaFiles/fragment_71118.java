lastQuery.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
      for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
        if (dataSnapshot.hasChild("JSON_OBJ")) {
            SubmitKey item = dataSnapshot.getValue(SubmitKey.class);
            String key2 = item.getJSON_OBJ();

        } else {
            Snackbar.make(findViewById(R.id.QuestionLayout), "JSON_ObJ not found", Snackbar.LENGTH_LONG).show();
        }
      }
    }