List<String> stringList = Arrays.asList(possible_names);

String firstName = stringList.get(new Random().nextInt(stringList.size()));

Collections.shuffle(stringList);
Optional<String> first = stringList.stream().filter(s -> firstName.length() + s.length() <= 12 && !s.equals(firstName)).findFirst();

System.out.println(firstName + first.get());