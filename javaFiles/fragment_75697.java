public String format(Stream<String> stream) {
    return stream.collect(
            () -> new Object() {
                StringJoiner stringJoiner = new StringJoiner(",");
                int count;

                @Override
                public String toString() {
                    return count == 1 ? stringJoiner.toString() : "[" + stringJoiner + "]";
                }
            },
            (container, currentString) -> {
                container.stringJoiner.add(currentString);
                container.count++;
            },
            (accumulatingContainer, currentContainer) -> {
                accumulatingContainer.stringJoiner.merge(currentContainer.stringJoiner);
                accumulatingContainer.count += currentContainer.count;
            }
                         ).toString();
}