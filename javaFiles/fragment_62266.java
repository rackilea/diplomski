public String[] listPokemon() {
    if(pk.length > 0){
        String[] Poke = new String[pk.length];
        for (int i = 0; i < pk.length; i++) {
            Poke[i] = pk[i].getSpecies();
        }

        return Poke;
    }
    else {
        return null;
    }
}