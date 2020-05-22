Map<String, Object> map = document.getData();
for (Map.Entry<String, Object> entry : map.entrySet()) {
    if (entry.getKey().equals("papers")) {
        Log.d("TAG", entry.getValue().toString());
    }
}