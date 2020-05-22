// ****** Change - add a flag to check to see if the first frame has been read
   boolean firstFrame = true;

   // ****** Change - declare previous frame here
   Mat previousFrame;
   while (keepProcessing)
    {   
        // ****** Change - Save previous frame before getting next one
        // Only do this if the first frame has passed
        if (!firstFrame)
            previousFrame = matFrame.clone();

        // grab the next frame from video source
        cap.grab();

        // decode and return the grabbed video frame
        cap.retrieve(matFrame);

        // if the frame is valid (not end of video for example)
        if (!(matFrame.empty()))
        {
            // **** Change - If we are on the first frame, only show that and
            // set the flag to false
            if (firstFrame) {
                ims.showImage(matFrame);
                firstFrame = false;
            }
            // ***** Change - now show absolute difference after first frame
            else {                
                Core.absdiff(matFrame, previousFrame, diffFrame);
                ims.showImage(diffFrame);                 
            }

            // display image with a delay of 40ms (i.e. 1000 ms / 25 = 25 fps)                
            Thread.sleep(40);
        } else { 
            keepProcessing = false;
        }
    }