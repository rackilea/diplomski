// first, second, d0, d1, di all typed by whatever getValue() returns...
// This assumes you have at least two elements in your Dices array

d0 = Dices[0].getValue();
d1 = Dices[1].getValue();
if (d0 > d1) {
    first=d0;
    second=d1;
} else {
    first=d1;
    second=d0;
}

for (int i = 2; i < Dices.length; i++) {
    di = Dices[i].getValue();
    if (di > first) {
        second = first;
        first = di;
    } else if (di > second)
        second = di;
}