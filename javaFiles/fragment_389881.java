String test = "{{1.23,8.4},{92.12,-0.57212}}";

double[][] vals = Arrays.stream(test.replaceAll(" ", "").split("},\\{"))
                        .map(str -> str.replaceAll("[{}]", "").split(","))
                        .map(Arrays::stream)
                        .map(stream -> stream.mapToDouble(Double::parseDouble)
                                             .toArray())
                        .toArray(double[][]::new);

System.out.println(Arrays.deepToString(vals));