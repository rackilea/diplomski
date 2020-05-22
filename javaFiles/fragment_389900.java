public void spielen () {
        new Thread(new Runnable() {

            @Override
            public void run() {
                if (guthaben > 0) {
                    if (endlosspielAktiv) {
                        while (guthaben > 0) {
                            kasten.Ringe.faerbeUm();
                            ZEICHENFENSTER.gibFenster().warte(500);                            
                            guthabenRunter();
                        }
                        setEndlosspielAktiv(false);
                    } else {
                        kasten.Ringe.faerbeUm();
                    }
                } else if (guthaben == 0) {
                    setEndlosspielAktiv(false);
                }
                guthabenRunter();
            }
        }).start();        
    }