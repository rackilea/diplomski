void colision() {
    for ( int i = 0; i < cant; i++ ) {

        boolean estChocando = personaje.x > o[i].x && personaje.x < o[i].x + o[i].tam && 
                              personaje.y > o[i].y && personaje.y < o[i].y + o[i].tam/2;

      if (estChocando && !personaje.estabaChocando) {

        //if( dist(personaje.x, personaje.y, o[i].x, o[i].y ) < (personaje.ph/2 + o[i].tam/2) ){

        personaje.restarVida();
        personaje.reiniciar();

        // remember the character was hit, so this condition won't be met the next time around
        personaje.estabaChocando = true;

      }

      // reset character was hit flag if no longer colliding
      if(!estChocando && personaje.estabaChocando){
        personaje.estabaChocando = false;
      }

    }
  }