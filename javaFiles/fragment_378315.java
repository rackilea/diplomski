try(BufferedReader bufferedReader= Files.newBufferedReader(Paths.get("test.csv"))) {
        CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(bufferedReader);
        Map<String,Integer> hearders = parser.getHeaderMap();
        Map<String,List<Double>> data = new HashMap<>();

        parser.getRecords().stream().forEach(rec -> {
            hearders.entrySet().forEach( head ->{
                data.computeIfAbsent(head.getKey(), k-> new ArrayList<>()).add(Double.parseDouble(rec.get(head.getValue())));
            });
        });
        System.out.println(data);
    }