class MovingMonster extends Monster implements Movable {
    @Override
    void step( MonsterPanel monsterPanel ) {
        ++phase;
    }
}