public void compareVoices(AudioInputStream ais,AudioInputStream ais2){
    for(int i = 0;i>ais.getFrameLength;i++){
        if(ais.read()!=ais2.read()){
            return(false);
        }
    }
    return(true);
}