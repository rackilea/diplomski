public class Numbers extends JTextPane implements Timing {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String phoneNumbersMap = "Start";

    private TimerCallback nos;

    public Numbers() {
        setPreferredSize(new Dimension(500, 250));
        nos = new TimerCallback(this, 100L);
        nos.start();
    }

    @Override
    public void tick() {
        phoneNumbersMap += "Test\n";
        String pn = phoneNumbersMap.toString();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Numbers.this.setText("Phone numbers: \n" + pn);
            }
        });
    }

}