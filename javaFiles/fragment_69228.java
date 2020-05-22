Table<Long, String, Integer> tableOne = HashBasedTable.create();
tableOne.put(1L, "Fruits", 20);
tableOne.put(2L, "Fruits", 30);
tableOne.put(2L, "Vegetables", 15);
tableOne.put(3L, "Vegetables", 10);

Table<Long, String, Integer> tableTwo = HashBasedTable.create();
tableTwo.put(2L, "Fruits", 10);
tableTwo.put(2L, "Vegetables", 40);
tableTwo.put(3L, "Fruits", 15);
tableTwo.put(4L, "Vegetables", 35);


HashBasedTable<Long, String, Integer> sumTable = Stream.concat(tableOne.cellSet().stream(), tableTwo.cellSet().stream())
        .collect(Tables.toTable(Table.Cell::getRowKey,
                Table.Cell::getColumnKey,
                Table.Cell::getValue,
                Integer::sum, HashBasedTable::create));

sumTable.cellSet().forEach(System.out::println);