Map<String, Object> map = documentSnapshot.getData();
for (Map.Entry<String, Object> entry : map.entrySet()) {
    if (entry.getKey().equals("Phonenumbers")) {
        Log.d("TAG", entry.getValue().toString());
    }
}