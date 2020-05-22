String input = "Z = x1 + x2 + 6716x3 + x4";
input = input.replace(" x", " 1x")
             .replaceAll("^[^x\\d]+", "");

double[] numbers = Pattern.compile("x\\d+[^x\\d]*")
        .splitAsStream(input)
        .mapToDouble(Double::parseDouble)
        .toArray();