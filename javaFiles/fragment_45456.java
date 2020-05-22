public void setIds(List<String> temp) {
        this.ids = new ArrayList<>(temp);
    }

    public List<String> getIds() {
        return Collections.unmodifiableList(ids);
    }