Soldier horseman = new Soldier("Horseman", 20);
Soldier spearman = new Soldier("Spearman", 10);
Soldier archer = new Soldier("Archer", 10);

horseman.setTarget(archer);
spearman.setTarget( horseman );
archer.setTarget(spearman);