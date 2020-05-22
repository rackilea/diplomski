call.enqueue(new Callback<List<DanceSchool>>() {
    @Override
    public void onResponse(....) {
        ........
        List<DanceSchool> danceSchools = response.body();
        accessArrayList(danceSchools);
        .......
    }
}