package mygame;
public class Character {

    public int attack, rangedAttack, manaAttack, defense, rangedDefense, manaDefense, strength, agility, intelligence ,race;
    String name;

    public Character(String name, int race) {
        this.name = name;
        this.race = race; 
    }
}