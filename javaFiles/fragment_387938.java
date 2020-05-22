public static void main(String args[]) {
  int contatore=0;
  //Worker prova = new Worker();
  //Seconda prova2 = new Seconda();
  //prova.start();
  //prova2.start();
  for(;;) {
     Worker prova = new Worker();
     Seconda prova2 = new Seconda();
     if(!prova.isAlive()) { 
        prova.start();
        contatore++;
     } 
     if(!prova2.isAlive()) { 
        prova2.start();
        contatore++;
     }
     if(contatore==50) System.out.println(""); 
     }
}