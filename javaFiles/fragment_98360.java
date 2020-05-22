List<String> list = new ArrayList();
Iterator<String> keys = response.keys();
while (keys.hasNext()) {
    try {
        list.add(response.getString(keys.next()));
    } catch (Exception e) {
      // ignore me
    }
}
ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);