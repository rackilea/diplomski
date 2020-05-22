public class GenPLCListener implements ActionListener {
    private GGCGuiLotto lotto;

    public GenPLCListener(GGCGuiLotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void actionPerfomred(ActionEvent e) {
        List<ImageIcon> slotList = lotto.getSlotList();
        Collections.shuffle(slotList);  // shuffle the list
        // do something else if need be.
    }
}