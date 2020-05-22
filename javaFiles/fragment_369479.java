List<Person> personList = new ArrayList<>();

    personList.add(new Person(1));
    personList.add(new Person(2));
    personList.add(new Person(3));
    personList.add(new Person(4));
    personList.add(new Person(5));
    personList.add(new Person(6));
    personList.add(new Person(7));

    List<StringBuilder> stringBuilderList = new ArrayList<>();

    int numberOfIntegerPerStringBuilder = 3;

    int index = 0;
    StringBuilder stringBuilder = null;
    for (Person person : personList) {

        if (index % numberOfIntegerPerStringBuilder == 0) {
            stringBuilder = new StringBuilder();
            stringBuilderList.add(stringBuilder);
        }

        if (stringBuilder != null) {
            stringBuilder.append(person.getAccount());
            stringBuilder.append(",");
        }
        index++;
    }

    for (StringBuilder sb : stringBuilderList) {
        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.println(sb.toString());
    }