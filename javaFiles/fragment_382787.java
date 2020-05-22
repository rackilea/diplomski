GenericRawResults<Foo> rawResults =
  orderDao.queryRaw(
    "select account_id,sum(amount) from orders group by account_id",
    new RawRowMapper<Foo>() {
            public Foo mapRow(String[] columnNames,
              String[] resultColumns) {
                return new Foo(Long.parseLong(resultColumns[0]),
                    Integer.parseInt(resultColumns[1]));
        }
    });