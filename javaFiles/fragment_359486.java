String[] texts = {
        "sunset lake michigan michigan alaska water florida "
        + "peninsula third largest water seventh largest water "
        + "percentage edit list largest country",

        "michigan alaska water florida peninsula third largest water "
        + "seventh largest water percentage edit list largest country "
        + "subdivision list political",

        "third largest water seventh largest water percentage edit list "
        + "largest country subdivision list political geographic "
        + "subdivisions total edit references"
    };
    List<String> joined = new ArrayList<String>();
    for (String text : texts) {
        List<String> textAsList = Arrays.asList(text.split(" "));
        final int N = joined.size();
        final int M = textAsList.size();
        for (int k = Math.min(N, M); k >= 0; k--) {
            if (joined.subList(N - k, N).equals(textAsList.subList(0, k))) {
                joined.addAll(textAsList.subList(k, M));
                break;
            }
        }
    }
    System.out.println(joined);