// list1 points to instance A
f(list1); // the value, instance A is passed
// list1 still points to instance A

void f(List<Player> x) {
    x = list2;
}