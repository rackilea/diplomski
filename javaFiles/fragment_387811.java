int count = 0;
int last = 0; // zero is not possible for prime-factors
for(int i=0;i<list.size();i++) {
    if(i == 0 || last == list.get(i)) count++;
    else {
        if(last > list.get(0)) {
            System.out.print(" * ");
        }

        System.out.print(last + (count > 1 ? "^" + count: ""));
        count = 1;
    }
    last = list.get(i);
}
//print last sequence.
if(last > 0) {
    if(last > list.get(0)) {
        System.out.print(" * ");
    }

    System.out.print(last + (count > 1 ? "^" + count: ""));
}