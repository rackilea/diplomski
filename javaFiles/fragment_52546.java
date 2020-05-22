tChart1.getHeader().setVisible(false);

    CircularGauge circularGauge1 = new CircularGauge(tChart1.getChart());

    circularGauge1.getFrame().setVisible(false);
    circularGauge1.getFaceBrush().setVisible(false);
    circularGauge1.setDisplayTotalAngle(180);
    circularGauge1.setTotalAngle(180);
    circularGauge1.setValue(200);
    circularGauge1.getTicks().setVisible(false);
    circularGauge1.setMinimum(0);
    circularGauge1.setMaximum(1000);
    circularGauge1.getAxis().getAxisPen().setVisible(false);
    circularGauge1.getAxis().setIncrement(500);
    circularGauge1.getRedLine().setVisible(false);
    circularGauge1.setGreenLineStartValue(0);
    circularGauge1.setGreenLineEndValue(1000);
    circularGauge1.getGreenLine().getGradient().setDirection(GradientDirection.HORIZONTAL);
    circularGauge1.getGreenLine().getGradient().setUseMiddle(true);
    circularGauge1.getGreenLine().getGradient().setStartColor(Color.orange);
    circularGauge1.getGreenLine().getGradient().setMiddleColor(Color.yellow);
    circularGauge1.getGreenLine().getGradient().setEndColor(Color.green);
    circularGauge1.getGreenLine().getPen().setVisible(false);