public IList<Integer, Term> add(IList<Integer, Term> p1, IList<Integer, Term> p2)
{
    IList<Integer, Term> addList = new LList<Integer, Term>();

    if (p1 == null || p2 == null) {
        return addList;
    }

    if(p1.getSize() >= p2.getSize() || p2.getSize() <= p1.getSize()){
        ...
    }

    ...
}