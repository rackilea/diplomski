LinkedList<Apartament> list1 = new LinkedList<>();
LinkedList<Apartament> list2 = new LinkedList<>();
for(Apartament a : myList) {
    if(a instanceof ApartamentLux) {
        list2.add(a);
    } else {
        list1.add(a);
    }
}