Field<DayToSecond> diff = DSL.timestampDiff(
    DSL.currentTimestamp(), 
    DSL.timestamp("2018-01-01 00:00:00")
);

Field<Double> d = DSL.field("{0}", diff.getDataType()
                                       .asConvertedDataType(Converter.ofNullable(
    DayToSecond.class,
    Double.class,
    DayToSecond::getTotalMinutes,
    m -> DayToSecond.valueOf(m * 60000) // Optional implementation here
)), diff);

System.out.println(create.select(d).fetchOne());