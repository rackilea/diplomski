// Hierarchy
abstract class Card
interface Hero
interface Villain
class HeroCard extends Card implements Hero
class VillainCard extends Card implements Villain

// Example constructors definitions for reference?
Card(String name, int value, int power);
HeroCard(String name, int value, int power);
VillainCard(String name, int value, int power);

// Create all heroes
List<Hero> heroes = new ArrayList<Hero>();
heroes.add(new HeroCard("Green Arrow", 5, 2));

// Create all villains
List<Villain> villains = new ArrayList<Villains>();
villains.add(new VillainCard("Ra's Al Ghul", 8, 3));

// All all the heroes and villains to all cards
List<Card> cards = new ArrayList<Card>();
cards.addAll(heroes);
card.addAll(villains);