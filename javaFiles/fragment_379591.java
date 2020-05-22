List<String> original = new ArrayList<>(Arrays.asList("Hello", "World"));

    // This simply decorates original, so updates to original are
    // reflected in this list.
    List<String> unmodifiableDecorator = Collections.unmodifiableList(original);

    // The reference to the new ArrayList is scoped to the call to
    // Collections.unmodifiableList, so nothing else can have a
    // reference to it.
    List<String> unmodifiableCopy =
        Collections.unmodifiableList(new ArrayList<>(original));

    System.out.println("Before clear:");
    System.out.println(original);
    System.out.println(unmodifiableDecorator);
    System.out.println(unmodifiableCopy);

    original.clear();

    System.out.println("After clear:");
    System.out.println(original);
    System.out.println(unmodifiableDecorator);
    System.out.println(unmodifiableCopy);