public class Test {

    public static void main(String[] args) {

        try {
            SynthLookAndFeel laf = new SynthLookAndFeel();
            laf.load(Test.class.getResourceAsStream("demo.xml"), Test.class);
            UIManager.setLookAndFeel(laf);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(new JSlider() {{
            setOrientation(JSlider.VERTICAL);
            setMinimum(-24);
            setMaximum(12);
            setVisible(true);
        }});
        f.setSize(320, 240);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}