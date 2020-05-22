weight = Double.parseDouble(txtWeight.getText());
minRun = Double.parseDouble(txtRun.getText());
minBsktBall = Double.parseDouble(txtBsktBall.getText());
hourSleep = Double.parseDouble(txtSleep.getText());
// That '1/2' is the real problem, it equates to '0' in integer logic!
// caloriesRun = (float) (minRun * 0.0175 * 10 * ((weight) * (1/2)));
caloriesRun = (float) (minRun * 0.0175 * 10d * ((weight) * (.5)));