public void getCale(ArrayList<Nod> lnoduri) {
    if (parent != null) {
        parent.getCale(lnoduri);
    }
    lnoduri.add(this);
}

public ArrayList<Nod> getCale() {
    ArrayList<Nod> result = new ArrayList();
    getCale(result);
    return result;
}