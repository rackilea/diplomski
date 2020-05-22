private void AddRootPanel(ArrayList<String> imageList) {
   rp = new RootPanel(imageList);
   Container container = getContentPane();
   container.add(rp.getScrollpane());
}

// Not require to extend JPanel for RootPanel class if it contains only single component
class RootPanel{
    private JScrollPane scrollpane;
    ...
    private void addImageLabel() {
        imgLabel = new JLabel();
        scrollPane= new JScrollPane(imgLabel);
        ...
    }
    public JScrollPane  getScrollpane(){
        return scrollPane;
    }
}