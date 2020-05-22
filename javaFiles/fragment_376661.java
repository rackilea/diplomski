Integer[] array = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87, 12};

int pos2 = 0, neg2 = 0;

for (int i : array) {
    if (i > 0) {
        pos2++;
    } else if(i < 0){
        neg2++;
    }
}

p1 = new int[pos2];
n1 = new int[neg2];

pos2 = 0;
neg2 = 0;

for (int i : array) {
    if (i > 0) {
        p1[pos2] = i;
        pos2++;
    } else if(i < 0){
        n1[neg2] = i;
        neg2++;
    }

}

System.out.print("Ukupno: ");
for (int i : array) {
    System.out.print(" " + i);
}

System.out.print("\nPozitivni: ");
for (int i : p1) {
    System.out.print(" " + i);
}

System.out.print("\nNegativni: ");
for (int i : n1) {
    System.out.print(" " + i);
}}}