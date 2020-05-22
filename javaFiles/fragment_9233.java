String genRand(int length){
   Random rand=new Random();
   String possibleLetters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ.";   
   StringBuilder sb = new StringBuilder(length);
   for(int i = 0; i < length; i++) 
      sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters.length())));
   return sb.toString();
}