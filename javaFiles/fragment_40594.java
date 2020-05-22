return checkExistingPerson.map(person -> {
    State state;

    if("blah".equals(person.getName())) {
        state = State.DUPLICATE;
    } else {
        state = State.NEW;
    }

    return Member(person.getId(), state);
})
.orElseGet(() -> Member(null, State.OK));