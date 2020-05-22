case 0:
        Bar bar1 = new Bar(tChart1.getChart());
        bar1.fillSampleValues();
        tChart1.getLegend().setSeries(tChart1.getSeries(0));
        tChart1.getLegend().setVisible(true);
        break;
    case 1:
        Pie pie1 = new Pie(tChart1.getChart());
        pie1.fillSampleValues();
        tChart1.getLegend().setSeries(tChart1.getSeries(0));
        tChart1.getLegend().setVisible(false);
        break;