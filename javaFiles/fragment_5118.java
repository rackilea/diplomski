final class Model {

    @JsonAdapter(AlwaysListTypeAdapterFactory.class)
    final List<String> foo = null;

    @JsonAdapter(AlwaysListTypeAdapterFactory.class)
    final List<SomeObject> bleh = null;

    @Override
    public String toString() {
        return "Model{" + "foo=" + foo + ", bleh=" + bleh + '}';
    }

}

final class SomeObject {

    final String some = null;

    @Override
    public String toString() {
        return "SomeObject{" + "some='" + some + '\'' + '}';
    }

}