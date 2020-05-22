while (!both.isEmpty() || !attackers.isEmpty() || !defenders.isEmpty()) {
    if (!attackers.isEmpty()) {
        team.setFirstPlayer(attackers.remove(new Random().nextInt(attackers.size())));
    } else if (!both.isEmpty()) {
        team.setFirstPlayer(both.remove(new Random().nextInt(attackers.size())));
    } else if (!defenders.isEmpty()) {
        team.setFirstPlayer(defenders.remove(new Random().nextInt(attackers.size())));
    }

    if (!defenders.isEmpty()) {
        team.setFirstPlayer(defenders.remove(new Random().nextInt(attackers.size())));
    } else if (!both.isEmpty()) {
        team.setFirstPlayer(both.remove(new Random().nextInt(attackers.size())));
    } else if (!attackers.isEmpty()) {
        team.setFirstPlayer(attackers.remove(new Random().nextInt(attackers.size())));
    }
}