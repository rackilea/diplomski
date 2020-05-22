int[] suitCounts = getEnumCount(cards, Suits.values().length,
    new GetEnumFromType<Card>(){
      public Enum getEnum(Card card) { return card.getSuit(); }
  });
int[] dayCounts = getEnumCount(days, DayOfWeek.values().length,
    new GetEnumFromType<Day>() {
      public Enum getEnum(Day day) { return day.getDayOfWeek(); }
  });
int[] dogCounts = getEnumCount(dogs, Breeds.values().length,
    new GetEnumFromType<Dog>(){
      public Enum getEnum(Dog fido) { return fido.getBreed(); }
  });