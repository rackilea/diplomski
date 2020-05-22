for (int i = 0; i < asteroids.size() - 1; i++) {
    for (int j = i + 1; j < asteroids.size(); j++) {
        if (asteroids[i].asteroidBounds.overlaps(asteroids[j].asteroidBounds))
            //Insert collision handling code here
    }
}