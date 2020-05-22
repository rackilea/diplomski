PokemonObject po = null; // base class type for Gibble and Squirtle
if (answers == 1) {
    Gible pokemon = new Gible("Gible","Gabite & Garchomp", "Achieving Level 24","Dragon Type","Ground Type", "Slash, Tackle, Sandtomb, Dragonclaw", "Monster & Dragon", true , "Gabite & Garchomp", "Slash!", "Tackle!" , "Sandtomb!", "Dragonclaw!", 239, 189, 179, 189, 183, 320);
    // do Gible-specific stuff here
    po = pokemon;
} else {
    Squirtle pokemon = new Squirtle("Squirtle","Wartortle & Blastoise", "Achieving Level 16","Water", "None", "Tackle, Water Gun, Hydro Pump, Skull Bash", "Monster & Water 1", true , "Wartortle & Blastoise", "Tackle!", "Water Gun!" , "Hydro Pump!", "Skull Bash!", 195, 229, 199, 227, 185, 292);
    // do Squirtle-specific stuff here
    po = pokemon;
}
// do general Pokemon stuff here
System.out.println(pokemon.getName());