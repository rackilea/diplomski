private List<SomeType> removeDuplicates(List<SomeType> listWithDuplicates) {
    /* Set of all attributes seen so far */
    Set<AttributeType> attributes = new HashSet<AttributeType>();
    /* All confirmed duplicates go in here */
    List duplicates = new ArrayList<SomeType>();

    for(SomeType x : listWithDuplicates) {
        if(attributes.contains(x.firstAttribute())) {
            duplicates.add(x);
        }
        attributes.add(x.firstAttribute());
    }
    /* Clean list without any dups */
    return listWithDuplicates.removeAll(duplicates);
}