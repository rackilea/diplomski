public void myMethod(int i) {
Preis = Preis - classicpreis;       
Locale currentlocale = Locale.GERMANY;

NumberFormat numberFormatter = 
NumberFormat.getCurrencyInstance(currentlocale);
String classicpreisx = numberFormatter.format(classicpreis);
String preisx = numberFormatter.format(Preis);
labelsumme.setText(String.valueOf("Summe: " + preisx));
classiciconlist.get(i + 1).setVisible(false);
x++;
}