ColumnPositionMappingStrategy<ValueHolder> strategy = new ColumnPositionMappingStrategy<>();
strategy.setType(ValueHolder.class);
strategy.setColumnMapping("key", "value");
FileWriter writer = new FileWriter("./settings.csv");
StatefulBeanToCsvBuilder<ValueHolder> csvBuilder = new StatefulBeanToCsvBuilder<>(writer);
StatefulBeanToCsv<ValueHolder> beanWriter = csvBuilder.withSeparator(';').withMappingStrategy(strategy).build();
beanWriter.write(content);
writer.close();