ArrayList<String> mentah = new ArrayList<String>();
mentah.add("Reza");
mentah.add("Fata");
mentah.add("Faldy");
mentah.add("Helsan");
mentah.add("Dimas");
mentah.add("Mamun");
mentah.add("Erik");
mentah.add("Babeh");
mentah.add("Tio");
mentah.add("Mamang");

List<List<String>> result = new ArrayList<List<String>>();

for (int j= 0; j< mentah.size() ; j+=3) {
    int end = mentah.size() <= j+2 ? mentah.size() : j+3;
    if(mentah.size() - j == 4) end = end +1;
    if(j != 9) result.add(mentah.subList(j, end));
}
    System.out.println(result);  
}