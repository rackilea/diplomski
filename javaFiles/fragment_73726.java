List<Bean> lb = new ArrayList<Bean>() {{
            add(new Bean("This is 1"));
            add(new Bean("This is 10"));
            add(new Bean("This is 11"));
            add(new Bean("This is 2"));
        }};
    final AlphaNumericComparator comparator= new AlphaNumericComparator();
    Ordering<Bean> nameOrdering = new Ordering<Bean>() {
        @Override public int compare(Bean left, Bean right) {
            return comparator.compare(left.getShape(),right.getShape());
        }
    };
    ImmutableSortedSet<Bean> sortedShapes = ImmutableSortedSet.orderedBy(nameOrdering).addAll(lb).build();
    List<Bean> orderedList = new ArrayList<>();
    orderedList.addAll(sortedShapes);
    System.out.println("orderedList:" + orderedList);