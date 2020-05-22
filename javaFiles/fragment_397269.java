import static java.util.stream.Collectors.toList;
.....

List<String> values = l.stream()
    .flatMap(x -> desiredKeys.stream()
            .filter(x::containsKey)
            .map(x::get)
    ).collect(toList());