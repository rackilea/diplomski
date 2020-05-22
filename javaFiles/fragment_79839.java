private List<Utente> elencoUtenti() {
    List<Utente> utenti = new ArrayList<Utente>();

    utenti.add(new Utente("Piero", "Bianchi", 45, "Roma", "info@pierobianchi.it", "test"));
    utenti.add(new Utente("Mario", "Rossi", 40, "Roma", "info@mariorossi.it", "test"));


    return utenti;
}
@Override
    public String toString() {
        return "Utente{" +
                "firstname=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", emps=" + emps +
                '}';
    }
public static void main(String args[]) {
    List<Utente> li = elencoUtenti();
    for(Utente u : li) {
        System.out.println(u);
    }
}