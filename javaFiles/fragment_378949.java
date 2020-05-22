class LM { // lambda
    static Predicate<Object> a = x -> x != null;
}

class MR { // method reference
    static Predicate<Object> a = Objects::nonNull;
}