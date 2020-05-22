Locale loc = Locale.US;

    // our concrete values to be formatted
    Moment moment = SystemClock.currentMoment();
    PlainDate calendarDate = moment.toLocalTimestamp().getCalendarDate();

    // get the localized clock pattern
    Map<String, String> textForms = CalendarText.getIsoInstance(loc).getTextForms();
    String pattern = 
            textForms.containsKey("F_Bhm") ? textForms.get("F_Bhm") : "h:mm B";

    // construct the style-based date formatter
    ChronoFormatter<PlainDate> f1 = 
            ChronoFormatter.ofDateStyle(DisplayMode.SHORT, loc);

    // construct the time formatter
    ChronoFormatter<Moment> f2 = ChronoFormatter.ofMomentPattern(
        pattern,
        PatternType.CLDR,
        loc,
        Timezone.ofSystem().getID());

    System.out.println(f1.format(calendarDate) + " " + f2.format(moment));
    // example output => "12/11/18 6:18 in the morning"