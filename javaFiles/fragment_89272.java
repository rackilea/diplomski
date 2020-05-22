final JSONObject jsonObject = ...
// ...
final Iterable<Void> voids = Iterables.transform(Arrays.asList(states), new Function<State, Void>() {
    @Override
    public Void apply(State currentState) {
        jsonObject.put(String.valueOf(currentState.getId()), currentState.getName());
        return null;
    }
});
for ( final Void v : voids ) {
    // do nothing
}