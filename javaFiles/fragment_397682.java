int fromIncluding = IntStream.range(0, elements.size())
    .filter(i -> elements.get(i).getAbbreviation().equals("MNO"))
    .findFirst().orElse(0);
int toIncluding = IntStream.range(fromIncluding, elements.size())
    .filter(i -> elements.get(i).getAbbreviation().equals("YZ1"))
    .findFirst().orElse(elements.size() - 1);

List<Element> mnoToYz1 = elements.subList(fromIncluding, toIncluding+1);