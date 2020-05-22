public class YourComponent extends JFrame { // or whatever it is you're extending

    // ....

    public void init() {
        // ...
        byte numButtonClicks = 0;

        tellingIntroButton.addActionListener(e -> {
            numButtonClicks ++;
            System.out.println(numButtonClicks);
        });
    }

    // ...
}