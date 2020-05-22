String input = "Z = x1 + x2 + 6716x3";
input = input.replaceAll("^[^x\\d]+", "");
double[] numbers = Pattern.compile("x\\d+[^x\\d]*")
        .splitAsStream(input)
        .mapToDouble(s -> s.isEmpty() ? 1d : Double.parseDouble(s))
        .toArray();