public ResturantPanel extends JPanel {

    public ResturantPanel(String name, String address, List<String> reviews, Icon icon){
        setLayout(new BorderLayout());
        JLabel iconLabel = new JLabel(theIcon);
        JLabel nameLabel = new JLabel(name);
        JLabel addressLabel = new JLabel(address);
        JPanel southReviewPanel = new JPanel();
        southReviewPanel.setLayout(new BoxLayout(southReviewPanel, BoxLayout.Y_AXIS);
        for (String review: reviews) {
            southReviewPanel.add(new JTextArea(review));
        }
        add(southReviewPanel);
        add(iconLabel, BorderLayout.West);
        JPanel northPane = new JPanel();
        northPane.setLayout(new BoxLayout(northPane, BoxLayout.Y_AXIS));
        northPane.add(nameLabel);
        northPane.add(addressLabel);
        add(northPane, BorderLayout.North);
    }
}