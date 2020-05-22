Cell[] classes = new Cell[] {
            new Cell(DayOfWeek.THURSDAY, LocalTime.of(12, 0)),
            new Cell(DayOfWeek.MONDAY, LocalTime.of(14, 0)),
            new Cell(DayOfWeek.THURSDAY, LocalTime.of(10, 0)),
            new Cell(DayOfWeek.FRIDAY, LocalTime.of(9, 0)),
            new Cell(DayOfWeek.THURSDAY, LocalTime.of(6, 0))
    };
    ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Pacific/Auckland"));
    final DayOfWeek currentDay = now.getDayOfWeek();
    final LocalTime currentTime = now.toLocalTime();
    Comparator<Cell> comparatorByTimeUntilNext = new Comparator<Cell>() {

        @Override
        public int compare(Cell c1, Cell c2) {
            return c1.getTimeUntilNext(currentDay, currentTime)
                    .compareTo(c2.getTimeUntilNext(currentDay, currentTime));
        }
    };
    Cell nextClass = Collections.min(Arrays.asList(classes), comparatorByTimeUntilNext);
    System.out.println("Next class from " + now + " is " + nextClass);