int last = integers.get(0);
for(int i = 1; i < integers.size(); i++) {
    if (integers.get(i).equals(last)) {
        integers.remove(i);
        i--;
    } else {
        last = integers.get(i);
    }
}