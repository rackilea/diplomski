int max = 0;
int min = 0;
for (int i = 1; i < x.length; i++) {
    if (x[i].getweight() > x[max].getweight) {
        max = i;
    } else if (x[i].getweight() < x[min].getweight) {
        min = i;
    }
}