for (int i = 0; i < I; i++) {
    Astronaut A, B;
    if (!(givenInts.contains(a))) {
        A = new Astronaut(a);
        allAstronauts.add(A);
    } else {
        //check all current astronauts for same name
        for (int t = 0; t < allAstronauts.size(); t++) {
            if (allAstronauts.get(t).getName().equals(a)) {
                A = allAstronauts.get(t);
            }
        }
    }
    if (!(givenInts.contains(b))) {
         B = new Astronaut(b);
         allAstronauts.add(B);
    } else {
        //check all current astronauts for same name
        for (int r = 0; r < allAstronauts.size(); r++) {
            if (allAstronauts.get(r).getName().equals(b)) {
                B = allAstronauts.get(r);
            }
        }
    }
    Pairing P = new Pairing(A,B);