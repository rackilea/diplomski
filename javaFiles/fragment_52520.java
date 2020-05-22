ObservableList<XYChart.Series> xys = bc.getData();
    for(XYChart.Series<String,Number> series : xys) {
        ArrayList<XYChart.Data> removelist = new ArrayList<>();

        for(XYChart.Data<String,Number> data: series.getData()) {
            if(data.getYValue().equals(0)) removelist.add(data);
        }

        series.getData().removeAll(removelist);
    }