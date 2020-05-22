for (Gast test : verwaltungG) {
        if (gast == test.getgNr()) {
            System.out.println("Diese Nummer ist leider schon vergeben");
            gastNummerPruefung = false;
            pruef1 = true;
        }
    }