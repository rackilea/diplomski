InputChar c=InputChar.X;
trý {
 c=InputChar.valueOf(charEntered);
} catch (IllegalArgumentException e){
 System.out.println("I don't know what to do with " + charEntered+", defaulting to X");

}