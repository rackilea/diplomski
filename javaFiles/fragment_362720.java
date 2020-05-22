interface MeleeWeapon {
    void hit();
    void cut();
}

interface FirearmWeapon {
   void fire();
   void reload();
}

interface MagicWeapon {
   void throw();
   void apply();
   void recharge();
}