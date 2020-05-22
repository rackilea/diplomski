String[] dayFormats = {"d"};
String[] monthFormats = {"MM","MMM","MMMM"};
String[] yearFormats = {"yy","yyyy"};
String[] sepFormats = {" ",".","/"};
String[][][] orders = { { dayFormats, monthFormats, yearFormats },
                        { dayFormats, yearFormats, monthFormats },
                        { monthFormats, dayFormats, yearFormats },
                        { monthFormats, yearFormats, dayFormats },
                        { yearFormats, dayFormats, monthFormats },
                        { yearFormats, monthFormats, dayFormats } };
for (String[][] parts : orders)
    for (String sep : sepFormats)
        for (String p1 : parts[0])
            for (String p2 : parts[1])
                for (String p3 : parts[2])
                    System.out.println(p1 + sep + p2 + sep + p3);