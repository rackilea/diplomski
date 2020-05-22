public class ButtonPrompt extends GraphicGen {
    JButton randomBtn = new JButton("Add Random Rectangle");        
    JButton inputCoordinates = new JButton("Input Rectangle Coordinates");
    final GraphicGen gg;

    public ButtonPrompt(GraphicGen gg) {
        this.gg = gg;
        ......

        ActionListener actionListenerRandom = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                gg.callGenRandom();
                gg.callRepaintOnMain();
            }
        };

        randomBtn.addActionListener(actionListenerRandom);

        ......
    }
}