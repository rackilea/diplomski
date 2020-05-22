Date startDate=new Date();
    long duration = 1000*60*1;//1 hour in milliseconds
    series1.getData().add(new XYChart.Data(startDate, machine, new ExtraData(duration, "status-green")));

    startDate = new Date(startDate.getTime()+duration);
    duration = 1000*60*1;//2 hours in milliseconds
    series1.getData().add(new XYChart.Data(startDate, machine, new ExtraData(duration, "status-red")));