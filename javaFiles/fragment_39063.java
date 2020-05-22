int count = 1;
for (int i = 0; i < smaller.size(); i++) {
    if (i + 1 > smaller.size() - 1 ||
              !smaller.get(i + 1).equals(smaller.get(i))) {
         result.add(count);
         result.add(smaller.get(i));
         count = 1;
    } else {
         count++;
    }
}