class FooClass {
    private String text;

    public void foo(JButton[] buttons) {
        for (JButton i : buttons) {
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text = e.getActionCommand(); 
                }
            });
        }
    }
}