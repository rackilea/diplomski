List<String> input = Arrays.asList("1604", "1606", "1609", "1610", "1702", "1733747", "1854", "18687", "18691", "18709", "18710", "18713", "18720", "192685", "19s100619916001", "19s100620272001", "20083461");
    Collections.shuffle(input);
    List<String> output = new ArrayList<>(input);
    Collections.sort(output);
    List<String> outputReversed = new ArrayList<>(output);
    Collections.sort(outputReversed, Collections.reverseOrder());