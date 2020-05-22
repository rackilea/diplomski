private HashMap<Integer, String[]> prizeWinners;

public PartsPortlet()
{
    prizeWinners = new HashMap<Integer, String[]>();
    prizeWinners.put(2009, new String[]{"Barack H. Obama"});
    prizeWinners.put(2008, new String[]{"Martti Ahtisaari"};
    prizeWinners.put(2007, new String[]{"IAEA", "Mohamed ElBaradei"});
    //and many more
}

public String getYearWon(String name) {
    for (int year : prizeWinners.keySet()) {
        if (Arrays.asList(prizeWinners.get(year)).contains(name)) {
            return String.valueOf(year);
        }
    }
    return null;
}