private boolean mostrarCentral(No2 no, double x) {
      if (no != null) {
        return no.elemento.getProbMandante() == x || 
                    mostrarCentral(no.esq,x) || 
                    mostrarCentral(no.dir,x);
      }
      return false;
   }