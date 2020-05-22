if (hero.position.y < ghost.position.y) {
    if (OverlapTester.overlapRectangles(ghost.bounds, hero.bounds)) {
        hero.hitGhost();
        listener.hit();
    }
}