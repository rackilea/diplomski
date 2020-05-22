//movement
public void setBesturing(int besturing) {

    besturing = waarde; <-- THIS LINE

    if(waarde == 0) {
        setVerPlaats( getVerPlaats() + richtingEnSnelheid);
    }
    else if(waarde == 1){
        setHorPlaats( getHorPlaats() + richtingEnSnelheid);
    }
}