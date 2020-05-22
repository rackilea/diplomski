map.put("Title", new Runnable() {
    @Override
    public void run() {
        object.setTitle(getString(attributes, VALUE_ATTR))
    }
});