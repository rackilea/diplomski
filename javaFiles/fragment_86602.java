System.out.println("final results are: ");

for (int i=0; i < listdiv.size(); i++) {
    boolean isDivisible = true;
    for (int c=0; c < listdivisor.size(); c++) {
        if (listdiv.get(i) % listdivisor.get(c) != 0) {
            isDivisible = false;
            break;
        }
    }

    if (isDivisible) {
        System.out.println(listdiv.get(i));
    }
}