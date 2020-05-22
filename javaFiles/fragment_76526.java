DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");

    List<Leads> allEventData = Arrays.asList(new Leads("16-02-2020"),
            new Leads("04-02-2020"), new Leads("08-02-2020"),
            new Leads("09-02-2020"));

    if (allEventData.isEmpty()) {
        System.out.println("No data");
    } else {
        YearMonth month = YearMonth.parse(allEventData.get(0).getDate(), dateFormatter);
        boolean otherMonthFound = false;
        for (Leads lead : allEventData) {
            if (! YearMonth.parse(lead.getDate(), dateFormatter).equals(month)) {
                otherMonthFound = true;
                break;
            }
        }
        if (otherMonthFound) {
            System.out.println("They are not all in the same month");
        } else {
            System.out.println("They are all in the same month " + month);
        }
    }