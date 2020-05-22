class MyActivity implements FragmentBListener {

    // Instantiate the fragments:
    private void initFragments() {
        ...
        _fragmentB.setListener(this);
    }

    public void onDelete() {
        _fragmentA.delete(...);
    }
}