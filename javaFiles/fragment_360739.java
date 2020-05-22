private class TimerListener implements ActionListener {
    private SimonPanel simonPanel;  // the Simon JPanel
    private int colorListIndex = 0; // index into the ArrayList of MyColor objects
    private int sliceCount = 0;
    private List<MyColor> myColorList; // the MyColor ArrayList -- the random colors to press
    private int maxCount;

    public TimerListener(SimonPanel simonPanel, List<MyColor> myColorList) {
        // pass in the key fields into the program via constructor parameter
        this.simonPanel = simonPanel;
        this.myColorList = myColorList;  // again the ArrayList that holds random MyColor objects
        maxCount = myColorList.size();  // size of my list
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // if index at the end of the list -- get out and clean up
        if (colorListIndex == maxCount) {
            // clear the display of "pressed" colors
            for (MyColor myColor : MyColor.values()) {
                simonPanel.setMyColorPressed(myColor, false);
            }

            // stop this timer
            ((Timer) evt.getSource()).stop();
            return;
        }

        // the listener is a little complex since it must turn on colors and turn them off 
        // which is why I use a sliceCount int counter variable here
        if (sliceCount == 0) {
            // turn on the next color in the list (using the index)
            MyColor myColor = myColorList.get(colorListIndex);
            simonPanel.setMyColorPressed(myColor, true);
            sliceCount++;
        } else if (sliceCount < TIME_SLICES - 1) {
            sliceCount++;
            return;
        } else if (sliceCount == TIME_SLICES - 1) {
            sliceCount = 0;
            MyColor myColor = myColorList.get(colorListIndex);
            simonPanel.setMyColorPressed(myColor, false);  // turn off the color 
            colorListIndex++;  // and increment the index
            return;
        }
    }
}