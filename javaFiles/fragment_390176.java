enum Skill {
    HEAL, HIDE, ATTACK, THROW
}

class Player {
    boolean canHeal = false;
    boolean canHide = false;
    boolean canAttack = false;
    boolean canThrow = false;

    Player(Skill[] skills) {
        for(skill : skills) {
            switch(skill) {
                case Skills.HEAL: canHeal = true;
                break;

                case Skills.HIDE: canHide = true;
                break;

                case Skills.ATTACK: canAttack = true;
                break;

                case Skills.THROW: canThrow = true;
                break;

                default: //error
            }
        }
    }

    void heal() {
        [...]
    }
    void hide() {
        [...]
    }
    void attack() {
        [...]
    }
    void throw() {
        [...]
    }
    boolean canHeal() {
        return canHeal;
    }
    boolean canHide() {
        return canHide;
    }
    boolean canAttack() {
        return canAttack;
    }
    boolean canThrow() {
        return canThrow;
    }
}