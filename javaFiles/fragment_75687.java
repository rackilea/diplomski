ArrayList<TheInterface> campiprenotati = new ArrayList<>();

public void prenotazioniCC7(){
    for (TheInterface entry : campiprenotati) {
        if ("7".equals(entry.getDimensioni())) { 
            System.out.println(entry.toString());
        } else {
            System.out.println("Campo non trovato");
        }
    }
}