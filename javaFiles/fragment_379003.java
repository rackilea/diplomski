CsvRoutines routines = new CsvRoutines();
    ColumnMapper mapper = routines.getColumnMapper();

    mapper.attributeToColumnName("name", "name");
    mapper.attributeToColumnName("gender", "gender");
    mapper.attributeToColumnName("number", "number");
    mapper.attributeToColumnName("address.firstLine", "address_first_line");
    mapper.attributeToColumnName("address.secondLine", "address_second_line");

    for (User user : routines.iterate(User.class, input)) {
        System.out.println(user.toString());
    }