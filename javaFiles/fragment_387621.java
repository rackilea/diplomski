Map<String, Map<Double,Long>> tmpMap = list.stream()
        .collect(
                groupingBy(Data::getName,
                        groupingBy(Data::getValue,counting())
                ));
// {Dummy={8.0=2, 7.0=3}, Ossas={10.0=3, 5.0=2}, Uvumvew={10.0=3, 11.0=1, 14.0=2}}