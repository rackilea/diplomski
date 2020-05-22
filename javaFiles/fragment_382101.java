yourService.getNewFlexTable(this.id, new AsyncCallback<ArrayList<String>>() {
    public void onSuccess(ArrayList<String> result) {
    For(int i=0;i<result.size;i++) {
            YourPanel.getInstance().add(result.get(i);
        } 
    }
});