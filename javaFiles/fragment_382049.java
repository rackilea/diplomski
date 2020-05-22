TextIO.put ("Player 1: What number are you aiming for? ");
dartOne = TextIO.getInt();
TextIO.put ("What is your multiplier? ");
multiplier = TextIO.getlnWord();
if (multiplier.equals("double")){
    dartOne = dartOne*2;
}
TextIO.putln("You hit " + multiplier + " " + dartOne + " !");