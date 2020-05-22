int playerAttack = player.attack();
int monsterAttack = monster.attack();

monster.getAttacked(playerAttack);
//etc

if (monster.getMonsterLiv() > 0)
{
    player.getAttacked(monster.attack());
    //etc
} else {
    //The monster dies from massive damage!
}