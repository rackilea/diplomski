for (UorPos u : uorsList) {
        String key = u.getNomeUorPos();
        if (orcMap.containsKey(key)) {
            orcMap.put(key, orcMap.get(key) + u.getOrc());
        } else {
            orcMap.put(key, u.getOrc());
        }
    }

    for (Treinamentos r : treinamentosList) {
        String key = r.getDivisao();
        if (rlzMap.containsKey(key)) {
            rlzMap.put(key, rlzMap.get(key) + r.getValorCurso());
        } else {
            rlzMap.put(key, r.getValorCurso());
        }
    }