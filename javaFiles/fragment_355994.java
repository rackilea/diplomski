List<Person> list1 = getPersonList1();
List<Person> list2 = getPersonList2();

list1.replaceAll(l1 -> list2.stream()
          .filter(l2 -> l2.getId().equals(l1.getId()))
          .findAny()
          .orElse(l1));

list1.addAll(list2.stream()
          .filter(l2 -> !list1.contains(l2))
          .collect(toList()));