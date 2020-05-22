public static class ChangingButton extends JButton {

    private final int[][] fModel;
    private final int fX;
    private final int fY;

    public ChangingButton(final int x, final int y, final int[][] model) {
        fX= x;
        fY= y;
        fModel= model;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fModel[fX][fY] = fModel[fX][fY] == 1 ? 0 : 1;
                updateNameFromModel();
            }
        });
        updateNameFromModel();
    }

    private void updateNameFromModel() {
        setText(String.valueOf(fModel[fX][fY]));
    }

}