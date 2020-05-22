OrientGraph graphThree = new OrientGraph(URL, USER, USER);
    try {
        ODocument pokemon = new ODocument("Pokemon");
        pokemon.field("name", "Raichu");

        OrientVertex v = graphThree.getVertex(pmRID);
        Map<String, ODocument> pokemons = v.getProperty("pokemons");
        if (pokemons == null) {
            pokemons = new HashMap();
        }
        pokemons.put("raichu", pokemon);
        v.setProperty("pokemons", pokemons);

        graphThree.commit();
    } catch (Exception e) {
        // ...
    } finally {
        graphThree.shutdown();
    }