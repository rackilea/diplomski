void mouseReleased() {
    int particleX = mouseX;
    int particleY = mouseY;

    Particle P = new Particle(); 
    P.setPos ( new PVector ( particleX, particleY ) ); // this needs to be implemented

    ParticleSystem.add ( P ); // this needs to be implemented
}