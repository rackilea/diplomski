String stringcomputerKeuze = "";
        int counter = 0;
        while (counter != 5) {
            int computerKeuze = rand.nextInt(lijstKaarten.size());
            stringcomputerKeuze = lijstKaarten.get(computerKeuze);
            counter++;
        }