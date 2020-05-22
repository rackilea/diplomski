String line = "@KEY,_,0,1,2  , _,4,5,6,";
List<Integer> collect = Arrays.stream(line.replaceAll("@KEY|_", "").split(","))
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .map(Integer::valueOf).collect(Collectors.toList());
System.out.println(collect);