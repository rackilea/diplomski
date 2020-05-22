Collections.sort(models, new Comparator<Model>() {
    @Override
    public int compare(Model item1, Model item2) {
        return Long.compare(item1.getUpdateAt(), item2.getUpdateAt());
    }
});