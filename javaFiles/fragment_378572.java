public static void main(String[] args) {
    // Leser verdi fra brukeren
    String tallTxt = showInputDialog("Antall US Dollar");
    int dollar = parseInt(tallTxt);
    double valuta = 5.49;
    // Beregner svarene av regnearbeidet /
    double svar1 = dollar * valuta;   
    //Skriv ut resultat
    showMessageDialog(null,   dollar  + " * " + valuta + " = " + svar1 + "\n");
}