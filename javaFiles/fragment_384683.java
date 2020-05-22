@Override
public int compare(Object obj1, Object obj2) {
    MyRecord d1 = (MyRecord) obj1;
    MyRecord d2 = (MyRecord) obj2;

    return d1.getPos_nr().compareTo(d2.getPos_nr());
    }

}