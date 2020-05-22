public String calRate(double currentMoney, double theTarget, double minBet) {
    while (currentMoney > minBet) {
        boolean win = winRate();
        if (win) {
            currentMoney += minBet;
        } else {
            currentMoney -= minBet;
        }
        if (currentMoney >= theTarget) {
            return "Won";
        }
    }
    return "Lose";
}