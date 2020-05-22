case 2:
{
    background(0);

    int playInvadersMoveSoundStart = 0;
    if (debug){
        double gameLoopStart = millis();
        println("fps " +frameRate);
        playInvadersMoveSoundStart = millis();
    }
    playInvadersMoveSound(); 
    if (debug){
        int playInvadersMoveSoundEnd = millis();
        int playInvadersMoveSoundTime = playInvadersMoveSoundEnd - playInvadersMoveSoundStart;
        println("playInvadersMoveSound " +playInvadersMoveSoundTime);
    }
}