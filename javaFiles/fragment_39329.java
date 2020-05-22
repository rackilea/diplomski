String output;
public void onCreate() {
    Setter.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            output  = "selected";
        }
    });
}