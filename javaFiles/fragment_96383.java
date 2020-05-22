void colision() {
    for ( int i = 0; i < cant; i++ ) {

        boolean estChocando = personaje.x > o[i].x && personaje.x < o[i].x + o[i].tam && 
                              personaje.y > o[i].y && personaje.y < o[i].y + o[i].tam/2;

      if (estChocando) {

        //if( dist(personaje.x, personaje.y, o[i].x, o[i].y ) < (personaje.ph/2 + o[i].tam/2) ){

        personaje.restarVida();
        personaje.reiniciar();

        // restore character to last non-collision position
        personaje.x = personaje.px;
        personaje.y = personaje.py;

      }

      // update position to restore to
      if(!estChocando){
        personaje.px = personaje.x;
        personaje.py = personaje.y;
      }

    }
  }