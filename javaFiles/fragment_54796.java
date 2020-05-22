for (UorPos u : uorsList) {
        orcMap.merge(u.getNomeUorPos(), u.getOrc(), (x, y) -> x + y);
    }

    for (Treinamentos r : treinamentosList) {
        rlzMap.merge(r.getDivisao(), r.getValorCurso(), (x, y) -> x + y);
    }