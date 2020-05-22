class Poppy extends Flower{

    @Override
    List<Season> seasons() {
        return Arrays.asList(Season.SPRING, Season.SUMMER);
    }
}

class Anthurium extends Flower{

    @Override
    List<Season> seasons() {
        return Season.allSeason();
    }
}