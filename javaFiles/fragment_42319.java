if (OverlapTester.overlapRectangles(hero.bounds, ghost.bounds)) {
    if (hero.position.y < ghost.position.y) {
        hero.hitGhost();
        listener.hit();
    } else {
        hero.hitGhostJump();
        listener.jump();
        break;
    }
}