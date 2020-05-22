public void prenotazioniCC7(){
    for (Campo campo : campiprenotati) {
// ------^^^^^^^^^^^
        if (campo instanceof Calcio && "7".equals(((Calcio)campo).getDimensioni())) { 
// ---------^^^^^^^^^^^^^^^^^^^^^^^^^^------------^^^^^^^^^^^^^^^
            System.out.println(campo.toString());
// ----------------------------^^^^^
        } else {
            System.out.println("Campo non trovato");
        }
    }
}