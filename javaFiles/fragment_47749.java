//movement
public void setBesturing(int besturing) {

    waarde = besturing; <-- THIS LINE

    if(waarde == 0) {
        setVerPlaats( getVerPlaats() + richtingEnSnelheid);
    }
    else if(waarde == 1){
        setHorPlaats( getHorPlaats() + richtingEnSnelheid);
    }
}