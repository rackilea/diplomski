@Override
public String toString() {
    return IntStream
            .range(0, nbits)
            .mapToObj(i -> get(i) ? '1' : '0')
            .collect(
                    () -> new StringBuilder(nbits),
                    (buffer, characterToAdd) -> buffer.append(characterToAdd),
                    StringBuilder::append
            )
            .toString();
}