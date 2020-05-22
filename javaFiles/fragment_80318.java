int checkCount = 0;
if (chk1.isSelected()) {
    checkCount++;
}
if (chk2.isSelected()) {
    checkCount++;
}    
if (chk3.isSelected()) {
    checkCount++;
}    
if (chk4.isSelected()) {
    checkCount++;
}    
if (chk5.isSelected()) {
    checkCount++;
}    
if (chk6.isSelected()) {
    checkCount++;
}

tFee = 2640 * checkCount;
lblMis.setText(Double.toString(misFee));
lblT.setText(Double.toString(tFee));