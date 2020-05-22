for (String year: years) {
    PrizeWinners[] list = winners.get(year);
    for (PrizeWinners names: list) {
        System.out.println(year + " " + names);
    }
}