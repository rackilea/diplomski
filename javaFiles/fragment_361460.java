public static void main(String[] args){

    JFrame frame = new JFrame("Temperature Converter");
    Temperature temp = new Temperature();

    JLabel temperature_label;
    JTextField farenheit_temperature;

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);

    frame.setLayout(new FlowLayout());

    temperature_label = new JLabel("Farenheit Converter");
    temperature_label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
    frame.getContentPane().add(temperature_label);

    farenheit_temperature = new JTextField("Enter Farenheit Temperature", 30);
    frame.getContentPane().add(farenheit_temperature);

    frame.setVisible(true);
}