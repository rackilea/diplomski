DateFormatSymbols symbols = DateFormatSymbols.getInstance();

final String[] romanMonths =  {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};
symbols.setMonths(romanMonths);

SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yy", symbols);

System.out.println("My date " + formatter.parse("05 X 02"));