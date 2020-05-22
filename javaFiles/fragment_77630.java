KTable<Windowed<Key>, Value> oneMinuteWindowed = yourKStream

.groupByKey()

.reduce(/*your adder*/, TimeWindows.of(60*1000, 60*1000), "store1m");
        //where your adder can be as simple as (val, agg) -> agg + val
        //for primitive types or as complex as you need