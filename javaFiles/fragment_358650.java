List<Thing> listOfThings = ...;

Table<Owner, Status, Long> table = 
    listOfThings.stream().collect(
        Tables.toTable(
            Thing::getOwner,             // Row key extractor
            Thing::getStatus,            // Column key extractor
            thing -> 1,                  // Value converter (a single value counts '1')
            (count1, count2) -> count1 + count2, // Value merger (counts add up)
            HashBasedTable::create       // Table creator
        )
    );