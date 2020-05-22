String shopChoice2 = shop.next();
System.out.println(shopChoice2);
if (shopChoice2.equals("iron sword")) {
    IronSword();"
} else if (shopChoice2.equals("rusty sword")) {
    RustySword();
} else if (shopChoice2.equals("light leather armor")) {
    LightleatherArmor();
} else if (shopChoice2.equals("minor health potion")) {
    MinorhealthPotion();
} else if (shopChoice2.isEmpty()) {
    Shop();
}