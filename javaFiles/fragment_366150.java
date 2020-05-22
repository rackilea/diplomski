IProperty<String> property = ...;
    String value = ...;

    Tuple<?, ?> t = new Tuple<>(property, value);

    withProperty(t);