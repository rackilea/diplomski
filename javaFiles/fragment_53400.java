String pmRID = "";

    OrientGraph graphTwo = new OrientGraph(URL, USER, USER);
    try {
        ODocument pokemon = new ODocument("Pokemon");
        pokemon.field("name", "Pikachu");
        Map<String,ODocument> foo = new HashMap();
        foo.put("pikachu", pokemon);

        OrientVertex v = graphTwo.addVertex("class:PokemonMaster",
                "name", "Sacha",
                "age", "42",
                "pokemons", foo);

        graphTwo.commit();
        pmRID = v.getIdentity().toString();
    } catch (Exception e) {
        // ...
    } finally {
        graphTwo.shutdown();
    }