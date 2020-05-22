Pattern p2 = Pattern.compile(",");
    Pattern p3 = Pattern.compile("=");
    String[] tokens = test.split(";");

    for (String token : tokens) {
        List<String> list = p2.splitAsStream(token)
                .flatMap(x -> p3.splitAsStream(x))
                .collect(Collectors.toList());

        result.put(list.get(5), IntStream.of(0, 2)
                .boxed()
                .collect(Collectors.toMap(list::get, x -> list.get(x + 1))));
    }

    System.out.println(result); // {1={name=ravi, age=30}, 2={name=teja, age=32}}