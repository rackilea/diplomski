class Gui {

    JButton buttons[];

    void create() {

        buttons = new JButton[5];
        for (int i=0; j<buttons.length; i++) { 
            int index = i;
            buttons[i] = new JButton("Button " + i);
            buttons[i].addActionListener(e -> clickedButton(index));
        }
    }

    private void clickedButton(int index) { 
        System.out.println("Clicked button at index " + index);
    }
}