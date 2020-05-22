CandleDataSet dataSet1 = new CandleDataSet(entries,"hr");

        CandleData candleData = new CandleData(time_steps,dataSet1);
        candleStickChart.setData(candleData);
        candleStickChart.setDrawGridBackground(false);
        candleStickChart.getAxisLeft().setDrawGridLines(false);
        candleStickChart.getXAxis().setDrawGridLines(false);
        candleStickChart.getAxisRight().setDrawGridLines(false);
        candleStickChart.setDrawBorders(false);
        candleStickChart.getXAxis().setTextColor(Color.parseColor("#FFF37D63"));
        candleStickChart.setBackgroundColor(Color.TRANSPARENT);


        candleStickChart.getLegend().setEnabled(false);
        candleStickChart.setDescription("");
        candleStickChart.getAxisLeft().setTextColor(Color.parseColor("#FFF37D63"));
        candleStickChart.getAxisRight().setEnabled(false);
        candleStickChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        candleStickChart.setPinchZoom(false);
        candleStickChart.setDoubleTapToZoomEnabled(false);