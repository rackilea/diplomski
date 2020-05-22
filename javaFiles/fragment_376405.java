Set<Integer> setA = new HashSet<>(Arrays.asList(1,2,3));
Set<Integer> setB = new HashSet<>(Arrays.asList(2,3,4));
Set<Integer> union = new HashSet<>();
union.addAll(setA);
union.addAll(setB);

Set<Integer> intersection = setA.parallelStream()
        .filter(setB::contains)
        .collect(Collectors.toSet());

System.out.println("Union : " + union);
System.out.println("Intersection : " +intersection);