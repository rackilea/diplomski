final ChartData chartData = new ChartData(
        new Title("Using labelFormatter function of axisY"),
        new Axis(
                "function(e) { return \"Y: \" + e.value; }"
        ),
        ImmutableList.of(
                new Datum(
                        "spline",
                        ImmutableList.of(
                                new DataPoint(5),
                                new DataPoint(9),
                                new DataPoint(17),
                                new DataPoint(32),
                                new DataPoint(22),
                                new DataPoint(14),
                                new DataPoint(25),
                                new DataPoint(18),
                                new DataPoint(20)
                        )
                )
        )
);
gson.toJson(chartData, System.out);