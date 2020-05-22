tChart1.getAspect().setView3D(false);
    tChart1.getLegend().setVisible(false);

    Area area1 = new Area(tChart1.getChart());
    area1.fillSampleValues();
    area1.setOrigin(0);
    area1.setUseOrigin(true);
    area1.getAreaLines().setVisible(false);

    area1.getGradient().setVisible(false);
    area1.setColor(Color.transparent);

    SeriesBand band1 = new SeriesBand(tChart1.getChart());
    band1.setSeries(area1);
    band1.getGradient().setVisible(true);
    band1.getGradient().setDirection(GradientDirection.VERTICAL);
    band1.getGradient().setStartColor(Color.green);
    band1.getGradient().setMiddleColor(Color.yellow);
    band1.getGradient().setUseMiddle(true);
    band1.getGradient().setEndColor(Color.red);