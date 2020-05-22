String text = "id1:name1,id2:name1,id3:name2,id4:name2,id5:name2";
Map<String, List<String>> map = Arrays
        .stream(text.split(","))
        .map(pair -> pair.split(":"))
        .collect(Collectors.groupingBy(
                    pair -> pair[1], 
                    Collectors.mapping(e -> e[0], Collectors.toList())
                )
        );

System.out.println(map);