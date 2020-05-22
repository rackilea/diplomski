Set<Sprite> toRemove = new HashSet<Sprite>();

for (Sprite s1 : sprites) {
    if (toRemove.contains(s1)) {
        continue;
    }
    s1.move();
    for (Sprite s : sprites) {
        if (toRemove.contains(s)) {
            continue;
        }
        if (s instanceof Attacker) {
            for (Sprite s2  : sprites) {
                if (toRemove.contains(s2)) {
                    continue;
                }
                if(s.overlaps(s2)) {
                    s2.hit();
                }
            }
        }
        if (s.shouldRemove()) {
            toRemove.add(s);
        }
    }
}

sprites.removeAll(toRemove);