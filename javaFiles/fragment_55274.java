// auxiliary method
public LocalDate ofYearDay(int prolepticYear, int dayOfYear) {
    boolean leap = (prolepticYear % 4) == 0;
    if (dayOfYear == 366 && leap == false) {
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + prolepticYear + "' is not a leap year");
    }
    Month moy = Month.of((dayOfYear - 1) / 31 + 1);
    int monthEnd = moy.firstDayOfYear(leap) + moy.length(leap) - 1;
    if (dayOfYear > monthEnd) {
        moy = moy.plus(1);
    }
    int dom = dayOfYear - moy.firstDayOfYear(leap) + 1;
    return LocalDate.of(prolepticYear, moy.getValue(), dom);
}

// sdf with UTC set, as above
Date date = sdf.parse("1400-04-01");
ZonedDateTime z = date.toInstant().atZone(ZoneOffset.UTC);

LocalDate d;
// difference between the ISO and Julian epoch day count
long julianToIso = 719164;
int daysPerCicle = (365 * 4) + 1;
long julianEpochDay = z.toLocalDate().toEpochDay() + julianToIso;
long cycle = Math.floorDiv(julianEpochDay, daysPerCicle);
long daysInCycle = Math.floorMod(julianEpochDay, daysPerCicle);
if (daysInCycle == daysPerCicle - 1) {
    int year = (int) ((cycle * 4 + 3) + 1);
    d = ofYearDay(year, 366);
} else {
    int year = (int) ((cycle * 4 + daysInCycle / 365) + 1);
    int doy = (int) ((daysInCycle % 365) + 1);
    d = ofYearDay(year, doy);
}
System.out.println(d); // 1400-04-01