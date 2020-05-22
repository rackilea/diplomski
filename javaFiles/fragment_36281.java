public class BadCombatant {

    ArtificialIntelligence ai = null;
    String someField;

    public BadCombatant() {
        this.ai = new ArtificialIntelligence(this);
        // Don't do this - ArtificialIntelligence constructor saw someField as null
        someField = "something"; 
    }