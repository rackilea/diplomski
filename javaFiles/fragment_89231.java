List<Integer> list = new ArrayList<>();
list.add(20);
list.add(20);
list.add(30);
list.add(40);
list.add(40);
list.add(20);
list.add(20);
list.add(20);

Integer curr = null;
int count = 0;
System.out.print("{");
for (int val : list) {
    if (curr == null) {
        curr = val;
        count = 1;
    }
    else if (curr != val) {
        System.out.print("(" + curr + ", " + count + ")");
        curr = val;
        count = 1;
    }
    else {
        ++count;
    }
}
System.out.print("(" + curr + ", " + count + ")");
System.out.print("}");

{(20, 2)(30, 1)(40, 2)(20, 3)}