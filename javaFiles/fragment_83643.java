public List<Fizz> applyChanges(List<Fizz> fizzes, Action action, Fizz toModify) {
    if (action == Action.Replace) {
        return fizzes.stream()
                .map(fizz -> fizz.getId() == toModify.getId() ? toModify : fizz)
                .collect(Collectors.toList());
    }
    return fizzes.stream()
            .filter(fizz -> fizz.getId() != toModify.getId())
            .collect(Collectors.toList());
}