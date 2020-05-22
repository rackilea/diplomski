DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

//using TreeMap for example
NavigableMap<Date, String> stringsByDate = new TreeMap<Date, String>();

//populate map
Date jan15th = dateFormat.parse("15 January 2013");
Date feb12th = dateFormat.parse("12 February 2013");
Date feb24th = dateFormat.parse("24 February 2013");
Date march18th = dateFormat.parse("18 March 2013");
stringsByDate.put(jan15th, "foo");
stringsByDate.put(feb12th, "bar");
stringsByDate.put(feb24th, "baz");
stringsByDate.put(march18th, "qux");

//define "from" and "to" keys
Date feb1st = dateFormat.parse("1 February 2013");
Date march1st = dateFormat.parse("1 March 2013");

//get the specified view
NavigableMap<Date, String> febStringsByDate = stringsByDate.subMap(
        feb1st,
        true,     //include Feb 1st
        march1st,
        false     //don't include March 1st
);

//prints {Tue Feb 12 00:00:00 EST 2013=bar, Sun Feb 24 00:00:00 EST 2013=baz}
System.out.println(febStringsByDate);