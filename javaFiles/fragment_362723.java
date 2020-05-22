class Peasant implements MeleeWeaponUser {
    public void use(MeleeWeapon weapon) {

    }
}

class Marine implements MeleeWeaponUser, FirearmWeaponUser {
    public void use(FirearmWeapon weapon) {

    }

    public  void use(MeleeWeapon weapon) {

    }
}

class Sorcerer implements MeleeWeaponUser, MagicWeaponUser {
    public  void use(MeleeWeapon weapon) {

    }

    public  void use(MagicWeapon weapon) {

    }
}