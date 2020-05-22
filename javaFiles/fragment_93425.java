Map<String, Set<Species>> planetSpecies = Stream
        .of(new Planet("blue planet", 45), 
            new Planet("red planet", 150), 
            new Planet("green planet", 77))
        .map(speciesMapper)
        .collect(
            Collectors.groupingBy(
                (PlanetSpecies sp) -> sp.getPlanet().getName(),
                Collectors.mapping(species -> species.getSpecies(), 
                        Collectors.reducing(new HashSet<Species>(), speciesReducer)
                        )
                ));