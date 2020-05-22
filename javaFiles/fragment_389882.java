Double[][] vals = Arrays.stream(test.replaceAll(" ", "").split("},\\{"))
                        .map(str -> str.replaceAll("[{}]", "").split(","))
                        .map(Arrays::stream)
                        .map(stream -> stream.map(Double::parseDouble)
                                             .toArray(Double[]::new))
                        .toArray(Double[][]::new);