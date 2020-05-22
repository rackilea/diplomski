public class MaskFormatterTest {
    private static final DateFormat df = new SimpleDateFormat("yyyy/mm/dd");


    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        JFormattedTextField tf = new JFormattedTextField(df);
        tf.setColumns(20);
        panel.add(tf);
        try {
            MaskFormatter dateMask = new MaskFormatter("####/##/##");
            dateMask.install(tf);
        } catch (ParseException ex) {
            Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}