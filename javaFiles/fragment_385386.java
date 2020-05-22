SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date = dateFormat.parse(created_view);
db.collection("Students")
        .whereGreaterThan("created_at", date)
        .get()
        .addOnCompleteListener(/* ... */);