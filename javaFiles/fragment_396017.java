Set<String> setA = new HashSet<>();
        setA.add("ABCD");
        setA.add("ABDC");

        Set<String> sorted = setA.stream()
            .map(s -> {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            })
            .collect(Collectors.toSet());

        sorted.forEach(s -> System.out.println(s));