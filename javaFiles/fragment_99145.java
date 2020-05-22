boolean hasNext = true;
    while(hasNext) { 
        hasNext = video.read(frame);
        numOfFrames++;

        if(numOfFrames == 100) { 
              break;  // calling this will break out of the loop
        }
   } // end while loop