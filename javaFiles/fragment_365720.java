strings.replaceAll(s -> {
    for (final Abreviation abb : Abreviation.values()){
        if (abb.contains(s)) {
            return abb.name();
        }
    }
    throw new IllegalArgumentException("Erreur");
});