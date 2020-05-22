final class Types {

    private Types() {
    }

    static final Type defaultFilterType = new TypeToken<Filter<Object>>() {
    }.getType();

    static final Type integerFilterType = new TypeToken<Filter<Integer>>() {
    }.getType();

    static final Type dateFilterType = new TypeToken<Filter<Date>>() {
    }.getType();

}