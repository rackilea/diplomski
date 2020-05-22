private static final Gson gson = new Gson();

private static final Type channelViewListType = new TypeToken<List<ChannelView>>() {
}.getType();

private static final Type myObjectListType = new TypeToken<List<MyObject>>() {
}.getType();

static Data testUsingDeserializationWithStrings(final Reader reader) {
    final List<MyObject> objects = gson.<List<ChannelView>>fromJson(reader, channelViewListType)
            .stream()
            .filter(Objects::nonNull)
            .map(view -> view.data)
            .filter(Objects::nonNull)
            .map(view -> view.value)
            .filter(Objects::nonNull)
            .map(view -> view.instruments)
            .map((Function<String, List<MyObject>>) instruments -> gson.fromJson(instruments, myObjectListType))
            .flatMap(Collection::stream)
            .collect(toList());
    return new Data(objects);
}

private static final class ChannelView {

    final DataView data = null;

}

private static final class DataView {

    final ValueView value = null;

}

private static final class ValueView {

    final String instruments = null;

}