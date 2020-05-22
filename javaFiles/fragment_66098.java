public static void main(String[] args) throws InterruptedException {
    String[] ganzeZeile = new String[27];
    List<String> filter = new ArrayList<String>();

    ganzeZeile[26] = "Ich gebe der Dozentin/dem Dozenten die Gesamtnote.";
    for (int i = 0; i < 11; i++) {
        filter.add("");
    }
    filter.add("dem Dozenten die Gesamtnote");

    System.out.println(ganzeZeile[26]);
    System.out.println(filter.get(11));
    System.out.println(ganzeZeile[26].contains(filter.get(11))); //prints true
}