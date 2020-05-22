public ObjectList derivative(ObjectList list1) {
    newList = new ObjectList();
    ObjectListNode p = list1.getFirstNode();
    while (p != null) {
        Term t1 = (Term) p.getInfo();
        if (t1.getExp() == 0) {
            Term t = new Term (0,0);
            newList.addLast(t);
            p = p.getNext();
        }
        else {
            Term t = new Term (t1.getCoeff()*t1.getExp(), t1.getExp() - 1);
            newList.addLast(t);
            p = p.getNext();
        }
    }
    return newList;
}