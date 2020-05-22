tChart1.getAspect().setOrthogonal(false);
    tChart1.getAspect().setZoom(70);
    tChart1.getAspect().setChart3DPercent(80);
    tChart1.getAxes().getDepth().setVisible(true);

    Surface surf1 = new Surface(tChart1.getChart());
    surf1.fillSampleValues(500);
    surf1.getPen().setVisible(false);