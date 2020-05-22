@SuppressWarnings("unchecked")
public static <R extends Rule, T extends Rule & Configurable> Key<R> create(R rule) {
    if (rule instanceof Configurable) {
        return (Key<R>)new ConfigurableRuleKey<>((T)rule);
    } else {
        return new RuleKey<>(rule);
    }
}