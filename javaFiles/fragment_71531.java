isPlaying = true;
while (isPlaying){

    if(worldBlock[curString].equals("Ocean")){
        chosenBlock = 0;
    }  else if(worldBlock[curString].equals("Fish")){
        chosenBlock = 1;
    }  else if(worldBlock[curString].equals("Shark")){
        chosenBlock = 2;
    }  else if(worldBlock[curString].equals("Treasure")){
        chosenBlock = 3;
    }  else  {
       isPlaying = false;   //Break out of the loop!
    }
}