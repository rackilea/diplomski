private void addNewValue(List<Float> data, float value) {
    final int MAX_DATA_SIZE = 20;
    data.add(Float.valueOf(value));
    if(data.size() > MAX_DATA_SIZE) {
        data.remove(0);
    }
}