public void applyChanges(List<Fizz> fizzes, Action action, Fizz toModify) {
    if (action == Action.Replace) {
        fizzes.replaceAll(fizz -> fizz.getId() == toModify.getId() ? toModify : fizz);
    } else {
        fizzes.removeIf(fizz -> fizz.getId() == toModify.getId());
    }
}