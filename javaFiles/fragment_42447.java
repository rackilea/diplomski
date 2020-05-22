public Lottery() {
    setLayout(new BorderLayout());

    title = new JLabel(Title, JLabel.CENTER);
    title.setFont(title.getFont().deriveFont(30.0f));
    add(title, BorderLayout.NORTH);


    subTitle = new JLabel("Lottery Numbers");
    subTitle.setHorizontalAlignment(JLabel.HORIZONTAL);
    add(subTitle, BorderLayout.SOUTH);
}