public class MyGui {
    private JButton go = new JButton("Go");
    private JButton stop = new JButton("stop");
    private int time = 0;

    public MyGui() {
        go.addActionListener(new ActionListener() {
            GregorianCalendar timesi = new GregorianCalendar();
            // int time1 = timesi.get(Calendar.MINUTE);
            time1 = timesi.get(Calendar.MINUTE); // use the field not a local class
        });

        // stop's listener added at the same level as the go's listener
        stop.addActionListener(new ActionListener() {
            GregorianCalendar timesi1 = new GregorianCalendar();
            int time2 = timesi1.get(Calendar.MINUTE);

            System.out.println(time2-time1);
        });

        // more code here
    }       

    // main method....
}