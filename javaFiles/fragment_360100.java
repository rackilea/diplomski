LinkedHashMap<Character, Long> counts = Pattern.compile(",")
        .splitAsStream(subjects)
        .collect(Collectors.groupingBy(
                s -> s.charAt(0),
                LinkedHashMap::new,
                Collectors.counting()));