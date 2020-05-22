@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public static class Triplet {
    public static List<Triplet> listFrom(List<String> strings) {
        Preconditions.checkArgument(strings.size() % 3 == 0);
        final List<Triplet> result = new ArrayList<>();
        for (int i=0; i<strings.size(); i+=3) {
            result.add(new Triplet(
                    strings.get(i), strings.get(i+1), strings.get(i+2)));
        }
        return result;
    }

    public final String verb;
    public final String noun1;
    public final String noun2;
}