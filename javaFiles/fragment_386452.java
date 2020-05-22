Random rand = new Random();
String stringcomputerKeuze = "";
while (true) {
        int computerKeuze = rand.nextInt(lijstKaarten.size());
        stringcomputerKeuze = lijstKaarten.get(computerKeuze);
}