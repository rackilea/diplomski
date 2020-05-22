@Override
public int compare(Object obj1, Object obj2) {
    MyRecord d1 = (MyRecord) obj1;
    MyRecord d2 = (MyRecord) obj2;

    int c1 = d1.getPos_nr().compareTo(d2.getPos_nr());

    if (c1 == 0) {
        int c2 = d1.getAltval().compareTo(d2.getAltval());

        return (c2 == 0) ? 1 : c2;

    } else {
        return c1;
    }
}

}