public <A extends Enum<A>, B extends Typed<A>> B any(Collection<B> haystack, A type, String... needles) {
    for (B straw : haystack)
        if (straw.getType().equals(type))
            for (String needle : needles)
                if (needle.equals(straw.getToken()))
                    return straw;
    return null;
}