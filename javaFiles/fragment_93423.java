Set<PlanetSpecies> planetSpecies = Stream
        .of(new Planet("blue planet", 45), 
            new Planet("red planet", 150), 
            new Planet("green planet", 77))
        .map(speciesMapper)
        .collect(Collectors.toSet());