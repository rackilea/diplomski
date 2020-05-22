@SuppressWarnings("unchecked")
public static <R extends Rule> Key<R> create(R rule) {
    if (rule instanceof Configurable) {
        return (Key<R>)new ConfigurableRuleKey<>((Configurable & Rule)rule);
    } else {
        return new RuleKey<>(rule);
    }
}