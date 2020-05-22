Parser<Student> parser = new Parser<>(Student::new,
                                      Parser.IGNORE, Parser.IGNORE, Student::setName);
List<Student> list = parser.parse(new String[][] {
                                      {null,         null,          "Moe" },
                                      {null,         null,          "Larry" },
                                      {null,         null,          "Curly" },
});
list.forEach(System.out::println);