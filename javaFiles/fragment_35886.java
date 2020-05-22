boolean wasAHeroBelowSixtyHp = false;
for (Hero myHeroes : heroes) {
    if (myHeroes.getCurrentHP() <= 60) {
        world.castAbility(hero, healerHeal, myHeroes.getCurrentCell());
        wasAHeroBelowSixtyHp = true;
    }
}
if (wasAHeroBelowSixtyHp) {
    // do something
}