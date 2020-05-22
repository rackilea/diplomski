Map<Character, Integer> scores =
    Stream.of("AEIOULNRST=1","DG=2","BCMP=3","FHVWY=4" /* etc */ )
        .flatMap(line -> line.split("=")[0].chars().mapToObj(c -> new Pair<>((char)c, Integer.parseInt(line.split("=")[1]))))
        .collect(Collectors.toMap(Pair::getKey, Pair::getValue));

System.out.println("C = " + scores.get('C'));