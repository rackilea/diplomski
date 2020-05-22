List<String> list = ...
int pct = 20;
String prefix = "x";

int idx = list.size() - list.size() * (100 - pct) / 100; // At least pct% of list
while (idx < list.size() && ! list.get(idx).startsWith(prefix))
    idx++;
List<String> part1 = list.subList(0, idx);
List<String> part2 = list.subList(idx, list.size());