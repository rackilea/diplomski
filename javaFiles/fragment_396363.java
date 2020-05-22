public void createChart(){
        series.getData().clear();
        int l=(int)Math.round(this.position-(this.tailleSerie/this.zoom));


        for(int i=l;i<this.position;i++){
            this.calendar.setTimeInMillis((time-((this.tailleSerie-1)-i))*60000);

            series.getData().add(new XYChart.Data(String.valueOf(this.myFormatter.format(calendar.get(Calendar.HOUR_OF_DAY)))+":"+String.valueOf(myFormatter.format(calendar.get(Calendar.MINUTE))), data.get(this.time-((this.tailleSerie-1)-i))));

        }


        ((ValueAxis<Number>) this.graph.getYAxis()).setLowerBound(min-(5*(max-min))/100);
        ((ValueAxis<Number>) this.graph.getYAxis()).setUpperBound(max+(5*(max-min))/100);

        this.graph.getData().clear();
        this.graph.getData().add(series);




}