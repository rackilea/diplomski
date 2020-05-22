CsvParserSettings parserSettings = new CsvParserSettings();
    parserSettings.getFormat().setLineSeparator("\n");

    final List<Customer> customers = new ArrayList<>();
    final java.util.Date stamp = getTimestamp(file);
    dao.checkTimestampDate(stamp);

    parserSettings.setProcessor(new BeanProcessor<Customer>() {
        @Override
        public void beanProcessed(Customer customer, ParsingContext context) {
            validateFileDateWithFileName(stamp, customer.getDay());
            validateCustomer(customer);
            customers.add(customer);
        }
    });

    new CsvParser(parserSettings).parse(file, "UTF-8");

    dao.save(customers);