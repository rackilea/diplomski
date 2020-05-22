public Vector crossover(Vector sot1, Vector sot2) {
    Vector sol1;
    Vector sol2;
    sol1 = copi(sot1);
    sol2 = copi(sot2);
    sol1.removeAll(Collections.singleton(null));
    sol2.removeAll(Collections.singleton(null));
    // int crosspoint = (int) sol1.size()/2 ;
    Vector son = new Vector();
    boolean awal = true;
    int size;
    if (sol1.size() < sol2.size()) {
        size = sol1.size();
        son.setSize(sol1.size());
        Collections.copy(son, sol1);
    } else {
        size = sol2.size();
        son.setSize(sol2.size());
        Collections.copy(son, sol2);
        awal = false;
    }
    int crosspoint = (int) (Math.random() * ((size * 2) / 3)) + 1;
    System.out.println("cross point :" + crosspoint);
    int j = crosspoint;
    if (awal == true) {
        for (j = crosspoint; j < size; j++) {
            //son.removeElementAt(j);
            // son.add(j, sol2.get(j));
            son.set(j, (Capaciter_n_objet) sol2.get(j));
        }
    } else {
        for (j = crosspoint; j < size; j++) {
            // son.removeElementAt(j);
            //son.add(j, sol1.get(j));
            son.set(j, (Capaciter_n_objet) sol1.get(j));
        }
    }
    son.removeAll(Collections.singleton(null));
    correction(son);
    son.removeAll(Collections.singleton(null));
    /* for(int i=0;i<non_packed_objet.size();i++)
     * System.out.println("non packed object : "+non_packed_objet.get(i));*/
    return son;
}