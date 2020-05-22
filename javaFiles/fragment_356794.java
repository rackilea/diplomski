Path path = Paths.get("passwordInput.txt");
Set<User> users = new TreeSet<>();

long matches = Paths.lines(path)
    .mapToLong(l -> users.stream()
        .map(User::getName).filter(l::equals).count())
    .sum();