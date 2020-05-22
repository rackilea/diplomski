Tuple key = new Tuple(row.getNum(0), row.getNum(1), row.getNum(2));
List<Integer> value = new ArrayList<>();
for (int cell = 3; cell < row.getCount(); cell++) {
    value.add(row.getNum(cell));
}
Map.put(key,value);