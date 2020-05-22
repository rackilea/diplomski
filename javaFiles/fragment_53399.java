OrientGraphNoTx graphOne = new OrientGraphNoTx(URL, USER, USER);
    try {
        OSchema schema = graphOne.getRawGraph().getMetadata().getSchema();

        OClass pokemon = schema.createClass("Pokemon");
        pokemon.createProperty("name", OType.STRING);

        OClass vClass = schema.getClass("V");
        OClass pokemonMaster = schema.createClass("PokemonMaster");
        pokemonMaster.setSuperClass(vClass);
        pokemonMaster.createProperty("name", OType.STRING);
        pokemonMaster.createProperty("age", OType.INTEGER);
        pokemonMaster.createProperty("pokemons", OType.EMBEDDEDMAP, pokemon);
    } finally {
        graphOne.shutdown();
    }