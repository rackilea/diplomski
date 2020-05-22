JCheckBox[] boxes = new JCheckBox[]{chk1, chk2, chk3, chk4, chk5, chk6};
tFee = 0;
for (JCheckBox box : boxes) {
    if (box.isSelected()) {
        tFee += 2640;
    }
}
lblMis.setText(Double.toString(misFee));
lblT.setText(Double.toString(tFee));