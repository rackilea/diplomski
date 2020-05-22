Character hero = null;
switch (chosenClass){
    case "Fighter":
        hero = new Fighter(name);
        break;
    case "Rogue":
        hero = new Rogue(name);
        break;
    case "Mage":
        hero = new Mage(name);
        break;
    case "Cleric":
        hero = new Cleric(name);
        break;
}
return hero;