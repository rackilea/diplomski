String s = "afafaffafafafffafaaaf";

Map<String, Long> freq = IntStream.range(0, s.length()-1).parallel() // 1
        .mapToObj(i -> s.substring(i, i + 2)) // 2
        .collect(Collectors.groupingBy(w -> w, Collectors.counting())); //3

System.out.println(freq);