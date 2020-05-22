@Test
public void getPreviousWorkingDayAsDate_whenMonday() {
    //given
    LocalDate monday = LocalDate.of(2017, 10, 16);
    Clock clock = Clock.fixed(monday.atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
    DateUtil.setClock(clock);

    LocalDate lastFriday = LocalDate.of(2017, 10, 13);

    //when
    Date previousWorkingDay = DateUtil.getPreviousWorkingDayAsDate();

    //then
    assertEquals(DateUtil.getDateFromLocalDate(lastFriday), previousWorkingDay);
}

@After
public void resetClock() {
    DateUtil.setClock(Clock.systemDefaultZone());
}