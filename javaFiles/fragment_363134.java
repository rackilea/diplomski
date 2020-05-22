Map<OldObject, NewObject> compared = new HashMap<>();

        Arrays.stream(Type.values()).collect(Collectors.toSet()).forEach(s ->
                compared.put(
                        oldObjectsSet.stream()
                                .filter(o -> o.getType().equals(s))
                                .findFirst()
                                .orElseThrow(),
                        newObjectsSet.stream()
                                .filter(m -> m.getType().equals(s))
                                .findFirst()
                                .orElseThrow()
                ));