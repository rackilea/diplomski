List<String> actual = new ArrayList<>();
List<String> required = new ArrayList<>();

List<String> common = new ArrayList<>(actual);
common.retainAll(required);

System.out.println(" 100.0 * common / actual = " + (actual.size() == 0 ? 0 : 100.0 * common.size() / actual.size()));
System.out.println(" 100.0 * common / required = " + (required.size() == 0 ? 0 : 100.0 * common.size() / required.size()));