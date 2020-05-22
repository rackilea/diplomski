if (arr == null) return 0;
Set<Integer> set = new HashSet<>();
int numDupes = 0;
for (int x : arr) { 
    if (set.contains(x)) numDupes++;
    set.add(x);
}