public class YourComponent extends JFrame { // or whatever it is you're extending

    // ....

    private int numButtonClicks = 0;

    public void init() {
        // ...

        tellingIntroButton.addActionListener(e -> {
            YourComponent.this.numButtonClicks++;
            System.out.println(numButtonClicks);
        });
    }

    // ...
}