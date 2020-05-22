//Old way:
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("The button was clicked using old fashion code!");
    }
});

//New way:
button.addActionListener( (e) -> {
        System.out.println("The button was clicked. From lambda expressions !");
});