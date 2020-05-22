// Mulit-Line Statement
List<String> strings = Arrays.stream(ppl)
        .filter((x) -> {
            return x.contains("(M)");
        })
        .collect(Collectors.toList());

// Single-Line Statement
List<String> strings = Arrays.stream(ppl)
        .map((x) -> x.toUpperCase())
        .filter((x) -> x.contains("(M)"))
        .collect(Collectors.toList());