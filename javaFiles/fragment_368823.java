Set<Wrapper> set = new HashSet<>();
for (ActualData item : listWithDuplicates) {
    if (!set.add(new Wrapper(item))) {
        System.out.println("Item "+item+" was a duplicate");
    }
}