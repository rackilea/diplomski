private boolean mostrarCentral(No2 no, double x) {
      boolean resp =false;

      if (no != null) {

        resp = resp || mostrarCentral(no.esq,x); // Elementos da esquerda

        System.out.println(" No is " + no.elemento.getProbMandante() + " |x is " + x);

       if(no.elemento.getProbMandante() == x){
                return true;
         }

        resp = resp || mostrarCentral(no.dir,x); // Elementos da direita.

      }
      return resp;
   }