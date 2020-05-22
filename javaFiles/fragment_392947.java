Document doc = Jsoup.parse(html);
Elements trs = doc.select("table.scl_list tr");
List<Meter> meters = new ArrayList<>();
for(int i = 1; i< trs.size(); i++){
    List<String> row = trs.get(i).select("th").stream().map(e -> e.text())
                            .collect(Collectors.toList());
    meters.add(new Meter(row));
} 
meters.forEach(System.out::println);