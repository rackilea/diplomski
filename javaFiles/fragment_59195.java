//osEvent
synchronized(this.list) {
   list.add( new Particle( message.x, message.y ) );
}

//draw
synchronized(this.list) {
  for( Particle p : list )
    {
        p.draw();
        if( p.isComplete ) {
            completedParticles.add( p );
        }   
    }
}