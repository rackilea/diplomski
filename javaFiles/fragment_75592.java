public static JRadioButton create(String title, final int x, final double y) {
    JRadioButton button = JRadioButton(title);
    button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            IOE.set(x, y);
            StringBuilder text = new StringBuilder("IOE:");
            for (int i = 0; i < 22; i++)
                text.append(IOE.get(i));
            label_IOE.setText(text + "% ");
        }
    });
    return button;
}