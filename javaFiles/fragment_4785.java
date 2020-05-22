private static final Joiner JOINER = Joiner.on(' ');
public List<String> mapToList(final Map<String, String> input){
    return Lists.newArrayList(
        Iterables.transform(
            input.entrySet(), new Function<Map.Entry<String, String>, String>(){
                @Override
                public String apply(final Map.Entry<String, String> input){
                    return JOINER.join(input.getKey(), input.getValue());
                }
            }));
}