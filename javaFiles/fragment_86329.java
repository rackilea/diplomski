public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
  List<String> dbDates = new List<>();
  for(DataSnapshot ds : dataSnapshot.getChildren()) {
    dbDates.add(ds.getValue(String.class);
  }
  for (int i=0; i < dates.length; i++) {
    if (dbDates.contains(dates[i])) {
      System.out.println("Database contains "+dates[i]);
    }
    else {
      System.out.println("Database does not contain "+dates[i]);
    }
  }
}