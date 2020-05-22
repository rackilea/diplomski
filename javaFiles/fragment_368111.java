public void setLayout(LayoutManager manager) {
    if(isRootPaneCheckingEnabled()) {
        getContentPane().setLayout(manager);
    }
    else {
        super.setLayout(manager);
    }
}