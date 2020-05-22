static final ChronoFormatter<HijriCalendar> HIJRI_FORMAT =
    ChronoFormatter
        .ofPattern("yyyy-MM-dd", PatternType.CLDR, Locale.ROOT, HijriCalendar.family())
        .withCalendarVariant(HijriCalendar.VARIANT_UMALQURA);
public String addDays(String date, int days) throws ParseException {
    HijriCalendar hcal = HIJRI_FORMAT.parse(date).plus(CalendarDays.of(days));
    return HIJRI_FORMAT.format(hcal);
}