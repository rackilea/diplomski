double chance = random.nextDouble();

if ((chance -= 0.4) < 0) {
    a();
} else if ((chance -= 0.2) < 0) {
    b();
} else if ((chance -= 0.2) < 0) {
    c();
} else {
    d();
}