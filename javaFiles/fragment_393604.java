assertEquals(expected.keySet(), actual.keySet());
    expected.forEach((state, list) -> {
        Collections.sort(list);
        Collections.sort(actual.get(state));
        assertEquals(list, actual.get(state));
    });