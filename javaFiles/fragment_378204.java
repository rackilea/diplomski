...
String line = text + " " + product + "s text, text text text text -";
line = line.trim(); // removes whitespaces.
if ( line.startsWith( product ) ) {
    product = capitalize ( product ); //or whatever.
}
UI.println(line);
...