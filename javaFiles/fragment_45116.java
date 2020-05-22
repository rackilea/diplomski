public static List<Details> getDuplicates(final List<Details> list) {
    return new ArrayList<>(list.stream()
            .collect(Collectors.toMap(dtl -> 
                            Arrays.asList(dtl.getTest0(), dtl.getTest1(), dtl.getTest2()), 
                    Function.identity(), Details::mergeDuplicates))
            .values());
}